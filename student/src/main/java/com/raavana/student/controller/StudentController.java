package com.raavana.student.controller;

import com.raavana.student.api.TestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController implements TestApi {


    @Override
    public ResponseEntity<String> testGet() {
        return ResponseEntity.ok("Hello from student Service!");
    }
}