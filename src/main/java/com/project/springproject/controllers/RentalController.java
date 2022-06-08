package com.project.springproject.controllers;

import com.project.springproject.models.Book;
import com.project.springproject.models.Rental;
import com.project.springproject.services.BookService;
import com.project.springproject.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RentalController {
    @Autowired
    RentalService rentalService;
    @Autowired
    BookService bookService;
    @GetMapping("/getRental")
    public String showBooks(Model model){
        List<Book> bookList=bookService.getAllBooks();
        for(int i=0;i<bookList.size();i++)
            if(bookList.get(i).isRented()==true)
                bookList.remove(i);
        model.addAttribute("getRental",bookList);
        return "booksForRent";
    }
    @RequestMapping("/rentBook")
    public String getRent(Long keyword ,Book book){
        rentalService.setRental(keyword,book);
        System.out.println(keyword);
        System.out.println(book.getId());
        return "loggedIn";
    }
    @GetMapping("/getRentedBooks")
    public String getRentedBooks(Model model)
    {
        List<Rental> rentalList=rentalService.getRentedBooks();
        model.addAttribute("rentedBook",rentalList);
        return "rentedBooks";

    }






}
