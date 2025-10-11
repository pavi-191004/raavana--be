package com.raavana.student.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {


    @GetMapping
    public ResponseEntity<String> testGet() {
        return ResponseEntity.ok("Hello from Student Service!");
    }
}