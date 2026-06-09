package com.ttknpdev.client.controller;

import com.ttknpdev.client.entities.many.Book;
import com.ttknpdev.client.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Provider is done (no authenticate)
@RestController
@RequestMapping(value = "/book")
public class RouterAuthorController {

    private final CommonService bookCommonService;

    @Autowired
    public RouterAuthorController(CommonService bookCommonService) {
        this.bookCommonService = bookCommonService;
    }

    @GetMapping(value = "/reads")
    private Iterable<Book> retrieveAllBooks() {
        return bookCommonService.reads();
    }

    @GetMapping(value = "/read")
    private Book retrieveBook(@RequestParam String bid) {
        return (Book) bookCommonService.read(bid);
    }

    @PostMapping(value = "/create")
    private Boolean addBook(@RequestBody Book book,@RequestParam String aid) {
        return bookCommonService.create(book,aid);
    }

    @DeleteMapping(value = "/delete")
    private Boolean removeBook(@RequestParam String bid) {
        return bookCommonService.delete(bid);
    }

}
