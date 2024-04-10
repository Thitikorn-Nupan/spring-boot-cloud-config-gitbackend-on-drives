package com.ttknpdev.client.dao;

import com.ttknpdev.client.entities.many.Book;
import com.ttknpdev.client.repositories.AuthorRepository;
import com.ttknpdev.client.repositories.BookRepository;
import com.ttknpdev.client.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDao implements BookService<Book> {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    @Autowired
    public BookDao(BookRepository bookRepository , AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Book> reads() {
        return bookRepository.findAll();
    }

    @Override
    public Book read(String bid) {
        return bookRepository.findById(bid).orElse(null);
    }

    @Override
    public Boolean create(Book obj,String aid) {
        // if we need to create , first we have to search Author by aid
        // because book table has foreign key
        return authorRepository.findById(aid).map(author -> {
            obj.setAuthor(author);
            bookRepository.save(obj);
            return true;
        }).orElse(false);
    }

    @Override
    public Boolean update(String aid, Book obj) {
        return null;
    }

    @Override
    public Boolean delete(String bid) {
        return bookRepository.findById(bid).map(book -> {
            bookRepository.delete(book);
            return true;
        }).orElse(false);
    }
}
