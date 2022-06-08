package com.project.springproject.controllers;

import com.project.springproject.models.Book;
import com.project.springproject.models.Client;
import com.project.springproject.models.ComicBook;
import com.project.springproject.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class ClientController {
    @Autowired
    ClientService clientService;


    @RequestMapping(value = "/deleteClient", method = RequestMethod.GET)
    public String handleDeleteUser(@RequestParam(value = "id") Long id) {
        clientService.deleteClient(id);
        return "loggedIn";
    }
    @GetMapping("/updateClient")
    public String updateClient(Model model)
    {
        model.addAttribute("clientupdate",new Client());

        return "updateClientForm";
    }

    @PostMapping("/process_UpdateClient")
    public String processUpdateClient(Client client){
        clientService.updateClient(client);
        return "loggedIn";
    }
    @GetMapping("/sortedUsers")
    public String viewUserSortedList(Model model){

        List<Client> listUser=clientService.getClients();
        listUser.sort(Comparator.comparing(Client::getFirstName));
        model.addAttribute("listUsers",listUser);
        return "users";
    }
    @RequestMapping(path = {"/searchEmail"})
    public String searchClients( String keyword, Model model) {

        List<Client> listBook = clientService.getClients();
        Stream<Client> stream = listBook.stream().filter(element -> element.getEmail().toLowerCase(Locale.ROOT).contains(keyword.toLowerCase(Locale.ROOT)));
        List<Client> listBookk = stream.collect(Collectors.toList());


        model.addAttribute("searchClientResult", listBookk);
        return "clientsearch";
    }
    @RequestMapping(path = {"/searchClientName"})
    public String searchByName (String keyword, Model model){


        List<Client> listclient = clientService.getClients();
        Stream<Client> stream = listclient.stream().filter(element -> element.getFirstName().toLowerCase(Locale.ROOT).contains(keyword.toLowerCase(Locale.ROOT)));
        List<Client> listClients = stream.collect(Collectors.toList());


        model.addAttribute("searchClientResult", listClients);

        return "clientsearch";
    }


}
