package com.ttknpdev.client.services;

import com.ttknpdev.client.entities.Student;
import com.ttknpdev.client.entities.one.Author;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class AuthorAndBookResponseService {
    private RestTemplate restTemplate;
    private HttpEntity httpEntity;

    public AuthorAndBookResponseService() {
        this.restTemplate = new RestTemplate();
    }
    public List<Author> reads(String url) {
        Author[] authors = restTemplate.getForObject(url,Author[].class); // get author objects form json
        assert authors != null;
        return Arrays.stream(authors).toList(); // convert to list
    }
    public Author read(String url) {
        return restTemplate.getForEntity(url,Author.class).getBody(); // get author objects form json
    }

    public Boolean create(String url, Author author) {
        httpEntity = new HttpEntity<Author>(author);
        return restTemplate.exchange(url, HttpMethod.POST,httpEntity, Boolean.class).getBody();
    }
    public Boolean update(String url,Author author) {
        httpEntity = new HttpEntity<Author>(author);
        return restTemplate.exchange(url, HttpMethod.PUT,httpEntity, Boolean.class).getBody();
    }

    public Boolean delete(String url) {
        return restTemplate.exchange(url, HttpMethod.DELETE,null, Boolean.class).getBody();
    }
}
