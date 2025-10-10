package com.raavana.student.service;

import com.raavana.student.entity.StudentOnboardingEntity;
import com.raavana.student.model.StudentDTO;
import com.raavana.student.repository.StudentOnboardingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j; 
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentOnboardingService {

    private final StudentOnboardingRepository repository;

    public StudentDTO saveStudent(StudentDTO studentDTO) {
        log.info("Saving student data for userId: {}", studentDTO.getUserId());

        StudentOnboardingEntity entity = StudentOnboardingEntity.builder()
                .userId(studentDTO.getUserId())
                .education(studentDTO.getEducation())
                .build();

        repository.save(entity);


        log.info("Student data saved successfully for userId: {}", studentDTO.getUserId());

        return studentDTO;
    }
}
