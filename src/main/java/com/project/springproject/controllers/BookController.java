package com.project.springproject.controllers;

import com.project.springproject.models.Book;
import com.project.springproject.models.Client;
import com.project.springproject.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/getAllBooks")
    public String getBook(Model model){
        List<Book> bookList=bookService.getAllBooks();
        model.addAttribute("bookList",bookList);
        return "books";
    }

    @GetMapping("/addBook")
    public String addBook(Model model)
    {
        model.addAttribute("book",new Book());

        return "addBookForm";
    }

    @PostMapping("/process_addBook")
    public String processAddBook(Book book){
        bookService.addBook(book);
        return "addBookSucces";
    }

   @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
   public String handleDeleteBook(@RequestParam(value = "id") Long id) {
        bookService.deleteBook(id);
       return "loggedIn";
   }

    @GetMapping("/updateBook")
    public String updateBook(Model model)
    {
        model.addAttribute("bookupdate",new Book());

        return "updateBookForm";
    }

    @PostMapping("/process_UpdateBook")
    public String processUpdateBook(Book book){
        bookService.updateBook(book);
        return "loggedIn";
    }
    @GetMapping("/sortedBooks")
    public String viewBookSortedList(Model model){

        List<Book> listUser=bookService.getAllBooks();
        listUser.sort(Comparator.comparing(Book::getTitle).thenComparing(Book::getAuthor));
        model.addAttribute("bookList",listUser);
        return "books";
    }

    @RequestMapping(path = {"/searchTitleBook"})
    public String search( String keyword, Model model) {

        List<Book> listBook = bookService.getAllBooks();

        Stream<Book> stream = listBook.stream().filter(element -> element.getTitle().toLowerCase(Locale.ROOT).contains(keyword.toLowerCase(Locale.ROOT)));
        List<Book> listBooks = stream.collect(Collectors.toList());
        model.addAttribute("searchResult", listBooks);
        return "bookssearch";
    }
        @RequestMapping(path = {"/searchAuthorBook"})
        public String searchByAuthor (String keyword, Model model){

            List<Book> listBook = bookService.getAllBooks();

            Stream<Book> stream = listBook.stream().filter(element -> element.getAuthor().toLowerCase(Locale.ROOT).contains(keyword.toLowerCase(Locale.ROOT)));
            List<Book> listBooks = stream.collect(Collectors.toList());
            model.addAttribute("searchResult", listBooks);

            return "bookssearch";
        }















}
