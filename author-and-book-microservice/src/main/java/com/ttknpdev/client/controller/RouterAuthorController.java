package com.ttknpdev.client.controller;

import com.ttknpdev.client.entities.one.Author;
import com.ttknpdev.client.logging.LogBack;
import com.ttknpdev.client.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Provider is done (no authenticate)
@RestController
@RequestMapping(value = "/author")
public class RouterAuthorController {
    private AuthorService authorService;
    private LogBack logBack;

    @Autowired
    public RouterAuthorController(AuthorService authorService) {
        this.authorService = authorService;
        logBack = new LogBack(RouterAuthorController.class);
    }
    @GetMapping(value = "/reads")
    private Iterable<Author> retrieveAllAuthors() {
        return authorService.reads();
    }

    @GetMapping(value = "/read")
    private Author retrieveAuthor(@RequestParam String aid) {
        return (Author) authorService.read(aid);
    }

    @PostMapping(value = "/create")
    private Boolean addAuthor(@RequestBody Author author) {
        /*
        request look like
        {
            "aid": "A002",
            "fullname": "Dway Ryder",
            "age": 33,
            "alive": false,
            "bookList": [ *** json array
                {
                    "bid": "B004",
                    "title": "Dare to done 1",
                    "releaseDate": "2015-01-19",
                    "price": 21.79
                },
                {
                    "bid": "B005",
                    "title": "Dare to done 2",
                    "releaseDate": "2015-05-19",
                    "price": 20.79
                }
            ]
        }

        result query look like
        Hibernate: insert into authors (age,alive,fullname,aid) values (?,?,?,?)
        Hibernate: insert into books (price,release_date,title,bid) values (?,?,?,?)
        Hibernate: insert into books (price,release_date,title,bid) values (?,?,?,?)
        **** insert (Fk can be null at the first time) first then update
        Hibernate: update books set aid=? where bid=? (aid from Author.aid)
        Hibernate: update books set aid=? where bid=? (aid from Author.aid)
        */
        logBack.log.debug("author stores {}",author); // Author{aid='A002', fullname='Dway Ryder', age=33, alive=false, bookList=[Book{bid='B004', title='Dare to done 1', releaseDate='2015-01-19', price=21.79}, Book{bid='B005', title='Dare to done 2', releaseDate='2015-05-19', price=20.79}]}
        return authorService.create(author);
    }

    @PutMapping(value = "/update")
    private Boolean editAuthor(@RequestParam String aid,@RequestBody Author author) {
        // logBack.log.debug("author stores {}",author); // Author{aid='A002', fullname='Dway Ryder', age=33, alive=false, bookList=[Book{bid='B004', title='Dare to done 1', releaseDate='2015-01-19', price=21.79}, Book{bid='B005', title='Dare to done 2', releaseDate='2015-05-19', price=20.79}]}
        return authorService.update(aid,author);
    }
    @DeleteMapping(value = "/delete")
    private Boolean removeAuthor(@RequestParam String aid) {
        return authorService.delete(aid);
    }
}
