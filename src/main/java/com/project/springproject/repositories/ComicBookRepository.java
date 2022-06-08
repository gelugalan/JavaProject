package com.project.springproject.repositories;


import com.project.springproject.models.ComicBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicBookRepository extends JpaRepository<ComicBook,Long> {
}
