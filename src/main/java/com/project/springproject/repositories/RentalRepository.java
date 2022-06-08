package com.project.springproject.repositories;


import com.project.springproject.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Long>  {
}
