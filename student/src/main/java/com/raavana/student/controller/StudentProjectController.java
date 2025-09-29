package com.raavana.student.controller;


import com.raavana.student.api.StudentApi;
import com.raavana.student.model.StudentDTO;
import com.raavana.student.service.StudentProjectService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentProjectController implements StudentApi {

    private final StudentProjectService studentProjectService;


    @Override
    public ResponseEntity<List<StudentDTO>> studentGet() {
        return ResponseEntity.ok(studentProjectService.studentGet());
    }

    @Override
    public ResponseEntity<StudentDTO> studentPost(StudentDTO body) {
        return ResponseEntity.ok(studentProjectService.studentPost(body));
    }

    @Override
    public ResponseEntity<StudentDTO> studentIdPut(String id, StudentDTO body) {
        return ResponseEntity.ok(studentProjectService.studentIdPut(id, body));
    }

    @Override
    public ResponseEntity<String> studentIdDelete(String id) { // fixed return type
        return ResponseEntity.ok(studentProjectService.studentIdDelete(id));
    }

    @Override
    public ResponseEntity<StudentDTO> studentIdGet(String id) {
        return ResponseEntity.ok(studentProjectService.studentIdGet(id));
    }
}

