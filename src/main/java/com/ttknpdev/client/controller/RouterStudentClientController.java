package com.ttknpdev.client.controller;

import com.ttknpdev.client.entities.Student;
import com.ttknpdev.client.services.StudentResponseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
@RefreshScope
public class RouterStudentClientController {
    private StudentResponseService service;

    public RouterStudentClientController() {
        service = new StudentResponseService();
    }

    @Value("${git.server.student.url}")
    private String url;
    @GetMapping("/url")
    public ResponseEntity<String> getUrl() {
        return ResponseEntity.ok().body(url);
    }

    @GetMapping(value = "/read")
    public ResponseEntity<Student> retrieveStudentByCodename(@RequestParam String codename) {
        String path = url+ "/read?codename="+codename;
        return ResponseEntity.ok().body(service.read(path));
    }

    @GetMapping(value = "/reads")
    public ResponseEntity<List<Student>> retrieveAllStudents() {
        String path = url+"/reads";
        return ResponseEntity.ok().body(service.reads(path));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Boolean> editStudent(@RequestParam String codename,@RequestBody Student student) {
        String path = url+"/update?codename="+codename;
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(path,student));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> removeStudent(@RequestParam String codename) {
        String path = url+"/delete?codename="+codename;
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.delete(path));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Boolean> addStudent(@RequestBody Student student) {
        String path = url+"/create";
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(path,student));
    }
}
