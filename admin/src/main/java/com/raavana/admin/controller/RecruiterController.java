package com.raavana.admin.controller;


import com.raavana.admin.api.RecruiterApi;

import com.raavana.admin.model.RecruiterDTO;
import com.raavana.admin.service.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recruiter")
@RequiredArgsConstructor
@Validated
public class RecruiterController implements RecruiterApi {

    private  final RecruiterService recruiterService;

    @Override
    public ResponseEntity<RecruiterDTO> add(RecruiterDTO body) {
        return recruiterService.add(body);
    }

    @Override
    public ResponseEntity<String> deleteById(String id) {
        return recruiterService.deleteById(id);
    }

    @Override
    public ResponseEntity<List<RecruiterDTO>> getAll() {
        return recruiterService.getAll();
    }

    @Override
    public ResponseEntity<RecruiterDTO> getById(String id) {
        return recruiterService.getById(id);
    }

    @Override
    public ResponseEntity<RecruiterDTO> updateById(String id, RecruiterDTO body) {
        return recruiterService.updateById(id,body);
    }

}
