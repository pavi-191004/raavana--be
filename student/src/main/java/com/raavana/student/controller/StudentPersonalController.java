package com.raavana.student.controller;

import com.raavana.student.api.StudentApi;
import com.raavana.student.model.StudentDTO;
import com.raavana.student.service.StudentPersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StudentPersonalController implements StudentApi {

    @Autowired
    private final StudentPersonalService studentService;

    @Override
    public ResponseEntity<String> studentIdDelete(String id) {
        return studentService.deleteStudent(id);
    }

    @Override
    public ResponseEntity<String> studentIdPut(String id, StudentDTO body) {
        return studentService.updateStudent(id,body);
    }

    @Override
    public ResponseEntity<String> studentPost(StudentDTO body) {
        return studentService.createStudent(body);
    }

}
