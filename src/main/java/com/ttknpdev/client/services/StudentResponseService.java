package com.ttknpdev.client.services;

import com.ttknpdev.client.entities.Student;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import java.util.List;

public class StudentResponseService {

    // Rest-template doesn't need to injection(It is not interface Right??). Remember this.
    private final RestTemplate restTemplate;
    private HttpEntity httpEntity;

    public StudentResponseService() {
        this.restTemplate = new RestTemplate();
    }

    public Student read(String url) {
        return restTemplate.getForEntity(url, Student.class).getBody();
    }

    public List<Student> reads(String url) {
        // second way to get list entity
        return (List<Student>) restTemplate.getForEntity(url, List.class).getBody();
    }

    public Boolean update(String url, Student student) {
        httpEntity = new HttpEntity<Student>(student);
        return restTemplate.exchange(url, HttpMethod.PUT, httpEntity, Boolean.class).getBody();
    }

    public Boolean delete(String url) {
        return restTemplate.exchange(url, HttpMethod.DELETE, null, Boolean.class).getBody();
    }

    public Boolean create(String url, Student student) {
        httpEntity = new HttpEntity<Student>(student);
        return restTemplate.exchange(url, HttpMethod.POST, httpEntity, Boolean.class).getBody();
    }
}
