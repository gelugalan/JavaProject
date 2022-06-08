package com.project.springproject.services;

import com.project.springproject.models.Client;
import com.project.springproject.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CostumUserDetailsService implements UserDetailsService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client= clientRepository.findByEmail(email);
        if(client==null){
            throw new UsernameNotFoundException("User not Found");
        }
        return new CostumUserDetails(client);
    }
}
