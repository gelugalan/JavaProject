package com.project.springproject.services;

import com.project.springproject.models.Book;
import com.project.springproject.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public void addBook(Book book) {
        bookRepository.save(book);

    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }


    public void updateBook( Book book) {

        bookRepository.save(book);

    }

    public Optional<Book> getById(long id) {
        return bookRepository.findById(id);
    }
    public List<Book> getAllShops(){
        List<Book> list =  (List<Book>)bookRepository.findAll();
        return list;
    }

    /*
     * TODO: Get Shop By keyword
     */
    public List<Book> getByKeyword(String keyword){
        return bookRepository.findByKeyword(keyword);
    }

}
