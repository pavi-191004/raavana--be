package com.raavana.recruiter.controller;


import com.raavana.recruiter.api.AddApi;
import com.raavana.recruiter.model.RecruiterDTO;
import com.raavana.recruiter.service.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RecruiterController implements AddApi {
  private final RecruiterService recruiterService;

    @Override
    public ResponseEntity<RecruiterDTO> addPost(RecruiterDTO body) {
        return ResponseEntity.ok(recruiterService.addPost(body));
    }
}
