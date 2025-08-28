package com.raavana.recruiter.controller;

import com.raavana.recruiter.api.HelloApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recruiter")
public class RecruiterController implements HelloApi {

        @GetMapping("/hello")
        public String sayHello() {
            return "Hello from Recruiter Service!";
        }

    @Override
    public ResponseEntity<String> helloGet() {
        return ResponseEntity.ok("Hello from Recruiter Service!");
    }
}
