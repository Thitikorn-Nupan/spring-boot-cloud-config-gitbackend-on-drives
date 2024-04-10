package com.ttknpdev.client.repositories;

import com.ttknpdev.client.entities.many.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,String> { }