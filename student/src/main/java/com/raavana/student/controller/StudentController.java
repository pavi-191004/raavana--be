package com.raavana.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/test")
    public String testApi() {
        return "API is working!";
    }
}
