package com.raavana.student.controller;

import com.raavana.student.api.StudentApi;
import com.raavana.student.model.StudentExperienceDTO;
import com.raavana.student.service.StudentExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentExperienceController implements StudentApi {

    @Autowired
    private final StudentExperienceService experienceService;

    @Override
    public ResponseEntity<String> studentIdDelete(String id) {
        return ResponseEntity.ok(experienceService.deleteExperience(id));
    }

    @Override
    public ResponseEntity<String> studentIdPut(String id, StudentExperienceDTO body) {
        return ResponseEntity.ok(experienceService.updateExperience(id,body));
    }

    @Override
    public ResponseEntity<String> studentPost(StudentExperienceDTO body) {
        return ResponseEntity.ok(experienceService.addExperience(body));
    }

}
