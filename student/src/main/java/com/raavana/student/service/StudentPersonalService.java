package com.raavana.student.service;

import com.raavana.student.entity.StudentPersonalEntity;
import com.raavana.student.model.StudentDTO;
import com.raavana.student.repository.StudentPersonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentPersonalService {

    @Autowired
    private final StudentPersonalRepository studentRepository;

    public ResponseEntity<String> deleteStudent(String id) {
        studentRepository.deleteById(id);
        return ResponseEntity.ok("Student Details Deleted");
    }

    public ResponseEntity<String> updateStudent(String id, StudentDTO body) {
        StudentPersonalEntity studentEntity = studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student Not Found: "+id));
        StudentPersonalEntity updateStudent = StudentPersonalEntity.builder()
                .id(studentEntity.getId())
                .profileImage(body.getProfileImage())
                .fullName(body.getFullName())
                .registerNo(body.getRegisterNo())
                .degree(body.getDegree())
                .field(body.getField())
                .mobile(body.getMobile())
                .gender(body.getGender())
                .domain(body.getDomain())
                .about(body.getAbout()).build();

        studentRepository.save(updateStudent);

        return ResponseEntity.ok("Student Details Updated");
    }

    public ResponseEntity<String> createStudent(StudentDTO body) {
        StudentPersonalEntity studentEntity = StudentPersonalEntity.builder()
                .profileImage(body.getProfileImage())
                .fullName(body.getFullName())
                .registerNo(body.getRegisterNo())
                .degree(body.getDegree())
                .field(body.getField())
                .mobile(body.getMobile())
                .gender(body.getGender())
                .domain(body.getDomain())
                .about(body.getAbout()).build();
        studentRepository.save(studentEntity);
        return ResponseEntity.ok("Student Details Created");
    }

}
