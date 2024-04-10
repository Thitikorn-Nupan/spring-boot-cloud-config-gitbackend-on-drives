package com.ttknpdev.client.controller;

import com.ttknpdev.client.entities.Student;
import com.ttknpdev.client.entities.one.Author;
import com.ttknpdev.client.services.AuthorAndBookResponseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/author")
public class RouterAuthorAndBookClientController {
    private AuthorAndBookResponseService service;
    @Value("${git.server.author.url}") // my router of author (One to many)
    private String url;

    public RouterAuthorAndBookClientController() {
        this.service = new AuthorAndBookResponseService();
    }

    @GetMapping(value = "/reads")
    public ResponseEntity<List<Author>> retrieveAllAuthors() {
        String path = url+"/reads";
        return ResponseEntity.ok().body(service.reads(path));
    }


    @GetMapping(value = "/read")
    public ResponseEntity<Author> retrieveAuthor(@RequestParam String aid) {
        String path = url+"/read?aid="+aid;
        return ResponseEntity.ok().body(service.read(path));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Boolean> addAuthor(@RequestBody Author author) {
        String path = url+"/create";
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(path,author));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Boolean> editAuthor(@RequestParam String aid,@RequestBody Author author) {
        String path = url+"/update?aid="+aid;
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(path,author));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> removeAuthor(@RequestParam String aid) {
        String path = url+"/delete?aid="+aid;
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.delete(path));
    }
}

