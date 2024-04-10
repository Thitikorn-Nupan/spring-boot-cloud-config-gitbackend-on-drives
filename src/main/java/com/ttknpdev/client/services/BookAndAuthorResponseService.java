package com.ttknpdev.client.services;

import com.ttknpdev.client.entities.many.Book;
import com.ttknpdev.client.entities.many.Book2;
import com.ttknpdev.client.entities.one.Author;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class BookAndAuthorResponseService {
    private RestTemplate restTemplate;
    private HttpEntity httpEntity;

    public BookAndAuthorResponseService() {
        this.restTemplate = new RestTemplate();
    }
    public List<Book2> reads(String url) {
        Book2[] book2s = restTemplate.getForObject(url,Book2[].class); // get author objects form json
        assert book2s != null;
        return Arrays.stream(book2s).toList(); // convert to list
    }

    public Book2 read(String url) {
        return restTemplate.getForEntity(url,Book2.class).getBody(); // get author objects form json
    }

    public Boolean create(String url,Book2 book2) {
        httpEntity = new HttpEntity<Book2>(book2);
        return restTemplate.exchange(url, HttpMethod.POST,httpEntity, Boolean.class).getBody();
    }
    public Boolean delete(String url) {
        return restTemplate.exchange(url, HttpMethod.DELETE,null, Boolean.class).getBody();
    }
}
