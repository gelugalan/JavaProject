package com.project.springproject.services;

import com.project.springproject.models.ComicBook;
import com.project.springproject.repositories.ComicBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicBookService {
    @Autowired

    ComicBookRepository comicBookRepository;


    public List<ComicBook> getAllComicBooks() {
        return comicBookRepository.findAll();
    }

    public void addComicBook(ComicBook comicBook) {
        comicBookRepository.save(comicBook);
    }


    public void deleteComicBook(Long id) {
        comicBookRepository.deleteById(id);
    }

    public void updateComicBook(ComicBook comicBook) {
        comicBookRepository.save(comicBook);
    }
}
