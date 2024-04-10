package com.ttknpdev.client.dao;

import com.ttknpdev.client.entities.one.Author;
import com.ttknpdev.client.repository.AuthorRepository;
import com.ttknpdev.client.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorImplement implements AuthorService<Author> {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorImplement(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> reads() {
        List<Author> authorList = new ArrayList<>();
        authorRepository.findAll().forEach(authorList::add); // loop and add value to list in one line
        return authorList;
    }
    /*
    result look like
    {
        "aid": "A000",
        "fullname": "Alex Slider",
        "age": 29,
        "alive": true,
        "bookList": [
            {
                "bid": "B000",
                "title": "Let her go",
                "releaseDate": "2013-03-31",
                "price": 13.79
            },
            {
                "bid": "B001",
                "title": "We did it",
                "releaseDate": "2007-01-01",
                "price": 9.79
            }
        ]
    },
    ...
    ..
    .

    result query look like
    Hibernate: select a1_0.aid , a1_0.age , a1_0.alive , a1_0.fullname from authors AS a1_0
    Hibernate: select bl1_0.aid , bl1_0.bid , bl1_0.price , bl1_0.release_date , bl1_0.title from books bl1_0 where bl1_0.aid = ? (aid from the first query)
    Hibernate: select bl1_0.aid , bl1_0.bid , bl1_0.price , bl1_0.release_date , bl1_0.title from books bl1_0 where bl1_0.aid=? (aid from the first query too)
    */

    @Override
    public Author read(String aid) {
        return authorRepository.findById(aid).orElse(null);
    }

    @Override
    public Boolean create(Author obj) {
        Author author = authorRepository.save(obj);
        return author != null;
    }

    @Override
    public Boolean update(String aid, Author obj) {
        return authorRepository.findById(aid).map(author -> {
            author.setAge(obj.getAge());
            author.setFullname(obj.getFullname());
            author.setAlive(obj.getAlive());
            authorRepository.save(author);
            // it knows which column was changed
            /*
            result query look like
            Hibernate: select a1_0.aid,a1_0.age,a1_0.alive,a1_0.fullname from authors a1_0 where a1_0.aid=?
            Hibernate: update authors set age=?,alive=?,fullname=? where aid=?
            */
            return true;
        }).orElse(false);
    }

    @Override
    public Boolean delete(String aid) {
        return authorRepository.findById(aid).map(author -> {
            authorRepository.delete(author);
            // it knows which column was changed (very easy to delete relations row in JPA !!!)
            /*
            result query look like
            ** first search aid if exist
            Hibernate: select a1_0.aid,a1_0.age,a1_0.alive,a1_0.fullname from authors a1_0 where a1_0.aid=?
            Hibernate: select bl1_0.aid,bl1_0.bid,bl1_0.price,bl1_0.release_date,bl1_0.title from books bl1_0 where bl1_0.aid=?
            ** update aid of book to be null before delete
            Hibernate: update books set aid=null where aid=?
            ** deleted book then auther
            Hibernate: delete from books where bid=?
            Hibernate: delete from authors where aid=?
            */
            return true;
        }).orElse(false);
    }
}
