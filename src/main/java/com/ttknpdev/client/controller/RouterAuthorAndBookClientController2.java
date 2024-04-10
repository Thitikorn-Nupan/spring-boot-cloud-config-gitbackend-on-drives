package com.ttknpdev.client.controller;

import com.ttknpdev.client.entities.many.Book2;
import com.ttknpdev.client.entities.one.Author;
import com.ttknpdev.client.services.BookAndAuthorResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class RouterAuthorAndBookClientController2 {
    private BookAndAuthorResponseService service;
    @Value("${git.server.author2.url[1]}") // my router of book (Many to one)
    private String url;
    public RouterAuthorAndBookClientController2() {
        this.service = new BookAndAuthorResponseService();
    }

    @GetMapping(value = "/reads")
    public ResponseEntity<List<Book2>> retrieveAllBooks() {
        String path = url+"/reads";
        return ResponseEntity.ok().body(service.reads(path));
    }

    @GetMapping(value = "/read")
    public ResponseEntity<Book2> retrieveBook(@RequestParam String bid) {
        String path = url+"/read?bid="+bid;
        return ResponseEntity.ok().body(service.read(path));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Boolean> addBook(@RequestBody Book2 book2,@RequestParam String aid) {
        String path = url+"/create?aid="+aid;
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(path,book2));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> removeBook(@RequestParam String bid) {
        String path = url+"/delete?bid="+bid;
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.delete(path));
    }
}
