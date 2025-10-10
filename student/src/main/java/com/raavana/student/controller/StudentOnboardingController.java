package com.raavana.student.controller;

import com.raavana.student.api.ApiApi;
import com.raavana.student.model.StudentDTO;
import com.raavana.student.service.StudentOnboardingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class StudentOnboardingController implements ApiApi {

    private final StudentOnboardingService studentOnboardingService;

    @Override
    public ResponseEntity<StudentDTO> addStudentEducationDetails(StudentDTO body) {
        log.info("Received request to add student education details for userId: {}", body.getUserId());

        StudentDTO savedStudent = studentOnboardingService.saveStudent(body);

        log.info("Successfully saved education details for userId: {}", savedStudent.getUserId());
        return ResponseEntity.status(201).body(savedStudent);
    }
}