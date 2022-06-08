package com.project.springproject.services;

import com.project.springproject.models.Book;
import com.project.springproject.models.Client;
import com.project.springproject.models.ComicBook;
import com.project.springproject.repositories.BookRepository;
import com.project.springproject.repositories.ClientRepository;
import com.project.springproject.repositories.ComicBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
@Autowired
    ClientRepository clientRepository;
    public void processRegistration(Client client) {
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        String encodedPassword=encoder.encode(client.getPassword());
        client.setPassword(encodedPassword);
        clientRepository.save(client);
    }
    public List<Client> getClients (){
        return clientRepository.findAll();
    }
}
