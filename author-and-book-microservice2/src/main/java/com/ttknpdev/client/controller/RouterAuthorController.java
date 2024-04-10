package com.ttknpdev.client.controller;

import com.ttknpdev.client.entities.many.Book;
import com.ttknpdev.client.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Provider is done (no authenticate)
@RestController
@RequestMapping(value = "/book")
public class RouterAuthorController {
    private BookService bookBookService;

    @Autowired
    public RouterAuthorController(BookService bookBookService) {
        this.bookBookService = bookBookService;
    }

    @GetMapping(value = "/reads")
    private Iterable<Book> retrieveAllBooks() {
        return bookBookService.reads();
    }

    @GetMapping(value = "/read")
    private Book retrieveBook(@RequestParam String bid) {
        return (Book) bookBookService.read(bid);
    }

    @PostMapping(value = "/create")
    private Boolean addBook(@RequestBody Book book,@RequestParam String aid) {
        return bookBookService.create(book,aid);
    }

    @DeleteMapping(value = "/delete")
    private Boolean removeBook(@RequestParam String bid) {
        return bookBookService.delete(bid);
    }

    /*

    @PutMapping(value = "/update")
    private Boolean editAuthor(@RequestParam String aid,@RequestBody Author author) {
        // logBack.log.debug("author stores {}",author); // Author{aid='A002', fullname='Dway Ryder', age=33, alive=false, bookList=[Book{bid='B004', title='Dare to done 1', releaseDate='2015-01-19', price=21.79}, Book{bid='B005', title='Dare to done 2', releaseDate='2015-05-19', price=20.79}]}
        return authorService.update(aid,author);
    }
  */
}
