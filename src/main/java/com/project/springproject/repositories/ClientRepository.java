package com.project.springproject.repositories;

import com.project.springproject.models.Book;
import com.project.springproject.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("SELECT u FROM Client u WHERE u.email=?1")
    Client findByEmail(String email);

}
