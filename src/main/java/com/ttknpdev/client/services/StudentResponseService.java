package com.ttknpdev.client.services;

import com.ttknpdev.client.entities.Student;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;


import java.util.List;

public class StudentResponseService {
    // Rest-template doesn't need to injection(It is not interface Right??). Remember this.
    private RestTemplate restTemplate;
    private HttpEntity httpEntity;
    public StudentResponseService() {
        this.restTemplate = new RestTemplate();
    }
    public Student read(String url) {
        return restTemplate.getForEntity(url,Student.class).getBody();
    }
    public List<Student> reads(String url) {
        /*
        // first way to get list entity
        Student[] object = restTemplate.getForObject(url,Student[].class);
        assert object != null;
        return Arrays.asList(object);*/
        // second way to get list entity
        return (List<Student>) restTemplate.getForEntity(url,List.class).getBody();
    }
    public Boolean update(String url,Student student) {
        httpEntity = new HttpEntity<Student>(student);
        // ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.PUT,httpEntity, Boolean.class);
        return restTemplate.exchange(url, HttpMethod.PUT,httpEntity, Boolean.class).getBody();
    }

    public Boolean delete(String url) {
        return restTemplate.exchange(url, HttpMethod.DELETE,null, Boolean.class).getBody();
    }

    public Boolean create(String url,Student student) {
        httpEntity = new HttpEntity<Student>(student);
        return restTemplate.exchange(url, HttpMethod.POST,httpEntity, Boolean.class).getBody();
    }
}
