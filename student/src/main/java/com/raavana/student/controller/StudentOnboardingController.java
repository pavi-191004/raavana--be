package com.raavana.student.controller;

import com.raavana.student.api.ApiApi;
import com.raavana.student.model.StudentDTO;
import com.raavana.student.service.StudentOnboardingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentOnboardingController implements ApiApi {

    private final StudentOnboardingService studentOnboardingService;

    @Override
    public ResponseEntity<StudentDTO> addStudentEducationDetails(StudentDTO body) {
        StudentDTO savedStudent = studentOnboardingService.saveStudent(body);
        return ResponseEntity.status(201).body(savedStudent);
    }

}
