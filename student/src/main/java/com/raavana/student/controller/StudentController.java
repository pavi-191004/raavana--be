package com.raavana.student.controller;



import com.raavana.student.api.AddApi;
import com.raavana.student.model.StudentDTO;
import com.raavana.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController implements AddApi {
    private final StudentService studentService;

    @Override
    public ResponseEntity<StudentDTO> addPost(StudentDTO body) {

        return ResponseEntity.ok(studentService.addPost(body));
    }
}