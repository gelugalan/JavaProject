package com.project.springproject.controllers;

import com.project.springproject.models.Book;
import com.project.springproject.models.Client;
import com.project.springproject.models.ComicBook;
import com.project.springproject.services.ComicBookService;
import com.project.springproject.services.HomeService;
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
public class ComicBookController {
    @Autowired
    ComicBookService comicBookService;
    @GetMapping("/getAllComicBooks")
    public String viewComicBookList(Model model){

        List<ComicBook> listComic =comicBookService.getAllComicBooks();
        model.addAttribute("comicbooklist", listComic );
        return "comicBooks";
    }

    @GetMapping("/addComicBook")
    public String addComicBook(Model model)
    {
        model.addAttribute("comicbook",new ComicBook());

        return "addComicBookForm";
    }

    @PostMapping("/process_addComicBook")
    public String processAddComicBook(ComicBook comicBook){
        comicBookService.addComicBook(comicBook);
        return "addComicBookSucces";
    }


    @RequestMapping(value = "/deleteComicBook", method = RequestMethod.GET)
    public String handleDeleteComicBook(@RequestParam(value = "id") Long id) {
        comicBookService.deleteComicBook(id);
        return "loggedIn";
    }
    @GetMapping("/updateComicBook")
    public String updateComicBook(Model model)
    {
        model.addAttribute("comicbookupdate",new ComicBook());

        return "updateComicBookForm";
    }

    @PostMapping("/process_UpdateComicBook")
    public String processUpdateComicBook(ComicBook comicBook){
        comicBookService.updateComicBook(comicBook);
        return "loggedIn";
    }
    @GetMapping("/sortedComicBook")
    public String viewComicBookSortedList(Model model){

        List<ComicBook> listComicBook=comicBookService.getAllComicBooks();
        listComicBook.sort(Comparator.comparing(ComicBook::getSeries).thenComparing(ComicBook::getNumber));
        model.addAttribute("comicbooklist",listComicBook);
        return "comicBooks";
    }

    @RequestMapping(path = {"/searchTitleComicBook"})
    public String searchComicBookBySeries( String keyword, Model model) {


        List<ComicBook> listComic = comicBookService.getAllComicBooks();
        Stream<ComicBook> stream = listComic.stream().filter(element -> element.getSeries().toLowerCase(Locale.ROOT).contains(keyword.toLowerCase(Locale.ROOT)));
        List<ComicBook> listComicBook = stream.collect(Collectors.toList());
        model.addAttribute("searchComicResult", listComicBook);
        return "comicbookssearch";
    }
    @RequestMapping(path = {"/searchNumberComicBook"})
    public String searchByAuthorComicBook (Integer keyword, Model model){

        List<ComicBook> listComic = comicBookService.getAllComicBooks();
        Stream<ComicBook> stream = listComic.stream().filter(element -> element.getNumber()==keyword);
        List<ComicBook> listComicBook = stream.collect(Collectors.toList());
        model.addAttribute("searchComicResult", listComicBook);
        return "comicbookssearch";
    }

}
