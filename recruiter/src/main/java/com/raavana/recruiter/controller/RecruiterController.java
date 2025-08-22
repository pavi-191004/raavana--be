package com.raavana.recruiter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recruiter")
public class RecruiterController {

        @GetMapping("/hello")
        public String sayHello() {
            return "Hello from Recruiter Service!";
        }

}
