package com.project.springproject.controllers;


import com.project.springproject.models.Client;
import com.project.springproject.models.ComicBook;
import com.project.springproject.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    HomeService homeService;

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }
    @GetMapping("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user",new Client());
        return "signUpForm";
    }
    @PostMapping("/process_register")
    public String processRegistration(Client client){
        homeService.processRegistration(client);
        return "register_succes";
    }
    @GetMapping("/list_users")
    public String viewUserList(Model model){

        List<Client> listUser=homeService.getClients();
        model.addAttribute("listUsers",listUser);
        return "users";
    }
    @GetMapping("/loggedIn")
    public String viewLoggedInPage()
    {
        return "loggedIn";
    }

}
