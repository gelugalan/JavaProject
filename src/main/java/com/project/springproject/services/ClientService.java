package com.project.springproject.services;

import com.project.springproject.models.Book;
import com.project.springproject.models.Client;
import com.project.springproject.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public void addClient(Client client) {
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        String encodedPassword=encoder.encode(client.getPassword());
        client.setPassword(encodedPassword);
        clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public void updateClient(Client client) {
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        String encodedPassword=encoder.encode(client.getPassword());
        client.setPassword(encodedPassword);
        clientRepository.save(client);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }
}
