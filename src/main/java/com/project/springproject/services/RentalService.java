package com.project.springproject.services;

import com.project.springproject.models.Book;
import com.project.springproject.models.Rental;
import com.project.springproject.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    @Autowired
    RentalRepository rentalRepository;

    public void RentBook(Rental rental) {
        rentalRepository.save(rental);
    }

    public void setRental(Long value, Book book) {
        Rental r=new Rental();
        r.setItemId(value);
        r.setUserId(book.getId());
        r.setRentDate("astazi");
    }

    public List<Rental> getRentedBooks() {
        return rentalRepository.findAll();
    }
}
