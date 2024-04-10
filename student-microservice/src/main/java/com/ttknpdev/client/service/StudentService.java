package com.ttknpdev.client.service;

import com.ttknpdev.client.entity.Student;
import com.ttknpdev.client.logging.LogBack;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students;
    private LogBack logBack;

    public StudentService() {
        students = new ArrayList<>();
        logBack = new LogBack(StudentService.class);
        students.add(new Student("0565505312-8", "Peter Parker", (short) 19, 'C'));
        students.add(new Student("0565505111-6", "Alex Ryder", (short) 19, 'B'));
        students.add(new Student("0565505365-2", "Kevin Owner", (short) 19, 'A'));
    }

    public Boolean addStudent(Student student) {
        return students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getByCodename(String codename) {
        // As of Java 8, we can also use the Stream API to find an element in a List.
        Student student = students.stream()
                .filter(element -> element.getCode().equals(codename))
                .findAny()
                .orElse(null);
        return student;
    }

    public Boolean editStudent(String codename, Student student) {
        return students.stream()
                .filter(element -> element.getCode().equals(codename))
                .findAny().map(studentExist -> {
                    System.out.println("found");
                    students.remove(studentExist);
                    System.out.println("deleted");
                    studentExist.setFullname(student.getFullname());
                    studentExist.setAge(student.getAge());
                    studentExist.setLevel(student.getLevel());
                    students.add(studentExist);
                    System.out.println("updated");
                    return true;
                }).orElse(false);
    }

    public Boolean deleteStudent(String codename) {
        return students.stream()
                .filter(element -> element.getCode().equals(codename))
                .findAny().map(studentExist -> {
                    System.out.println("found");
                    students.remove(studentExist);
                    System.out.println("deleted");
                    return true;
                }).orElse(false);
    }

}
