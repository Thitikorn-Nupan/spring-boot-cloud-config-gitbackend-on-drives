package com.ttknpdev.client.repositories;

import com.ttknpdev.client.entities.one.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,String> { }
