package org.mahanth.springsecurityapplication.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.mahanth.springsecurityapplication.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    List<Student> studentList = new ArrayList<>(Arrays.asList(
            new Student(1, "Aarav", 85),
            new Student(2, "Isha", 92),
            new Student(3, "Rohan", 76),
            new Student(4, "Sneha", 88),
            new Student(5, "Kiran", 69),
            new Student(6, "Meera", 95),
            new Student(7, "Vikram", 81),
            new Student(8, "Ananya", 90),
            new Student(9, "Rahul", 73),
            new Student(10, "Pooja", 87),
            new Student(11, "Arjun", 79)
    ));

    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){

        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrftoken(HttpServletRequest httpServletRequest){

        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }

    @PostMapping("addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student){

        studentList.add(student);
        return new ResponseEntity<>("Student Successfully added", HttpStatus.CREATED);
    }
}
