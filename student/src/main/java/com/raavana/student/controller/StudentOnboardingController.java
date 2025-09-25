package com.raavana.student.controller;

import com.raavana.student.api.ApiApi;
import com.raavana.student.model.StudentDTO;
import com.raavana.student.service.StudentOnboardingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/studentonboarding")
public class StudentOnboardingController implements ApiApi {
    private final StudentOnboardingService studentOnboardingService;


    @Override
    public ResponseEntity<StudentDTO> addStudentEducationDetails(StudentDTO body) {
        return  ResponseEntity.ok(studentOnboardingService.studentPost(body));
    }
}
