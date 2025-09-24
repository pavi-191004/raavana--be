package com.raavana.admin.controller;


import com.raavana.admin.api.RecruiterApi;

import com.raavana.admin.model.RecruiterDTO;
import com.raavana.admin.service.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recruiter")
@RequiredArgsConstructor
public class RecruiterController implements RecruiterApi {

    private  final RecruiterService recruiterService;


    @Override
    public ResponseEntity<List<RecruiterDTO>> recruiterGet() {

        return recruiterService.recruiterGet();
    }

    @Override
    public ResponseEntity<String> recruiterIdDelete(String id) {
        return recruiterService.recruiterIdDelete(id);
    }

    @Override
    public ResponseEntity<RecruiterDTO> recruiterIdGet(String id) {
        return recruiterService.recruiterIdGet(id);
    }

    @Override
    public ResponseEntity<RecruiterDTO> recruiterIdPut(String id, RecruiterDTO body) {
        return recruiterService.recruiterIdPut(id,body);
    }

    @Override
    public ResponseEntity<RecruiterDTO> recruiterPost(RecruiterDTO body) {
        return recruiterService.recruiterPost(body);
    }
}
