package com.raavana.student.controller;

import com.raavana.student.api.StudentsApi;
import com.raavana.student.model.StudentProfileDTO;
import com.raavana.student.service.GetProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class GetProfileController implements StudentsApi {

    private final GetProfileService getProfileService;

    @Override
    public ResponseEntity<List<StudentProfileDTO>> studentsGet() {
        return ResponseEntity.ok(getProfileService.getAll());
    }

    @Override
    public ResponseEntity<StudentProfileDTO> studentsIdGet(String id) {
        return ResponseEntity.ok(getProfileService.getById(id));
    }

}