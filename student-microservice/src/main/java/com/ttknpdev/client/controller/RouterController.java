package com.ttknpdev.client.controller;

import com.ttknpdev.client.entity.Student;
import com.ttknpdev.client.logging.LogBack;
import com.ttknpdev.client.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class RouterController {
    private StudentService service;

    private LogBack logBack;

    public RouterController() {
        this.service = new StudentService();
        logBack = new LogBack(RouterController.class);
    }

    @GetMapping(value = "/read")
    private Student retrieveStudentByCodename(@RequestParam String codename) {
        logBack.log.info("You called localhost:8081/student/read?codename="+codename);
        return service.getByCodename(codename);
    }

    @GetMapping(value = "/reads")
    private List<Student> retrieveAllStudents() {
        logBack.log.info("You called localhost:8081/student/reads");
        return service.getStudents();
    }

    @PostMapping(value = "/create")
    private Boolean addStudent(@RequestBody Student student) {
        logBack.log.info("You called localhost:8081/student/create and passed {} object on http body",student);
        return service.addStudent(student);
    }

    @PutMapping(value = "/update")
    private Boolean editStudent(@RequestParam String codename,@RequestBody Student student) {
        logBack.log.info("You called localhost:8081/student/update?codename={} and passed {} object on http body",codename,student);
        return service.editStudent(codename, student);
    }

    @DeleteMapping(value = "/delete")
    private Boolean removeStudent(@RequestParam String codename) {
        logBack.log.info("You called localhost:8081/student/delete?codename={}",codename);
        return service.deleteStudent(codename);
    }

}
