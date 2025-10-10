package com.raavana.student.service;

import com.raavana.student.entity.StudentOnboardingEntity;
import com.raavana.student.model.StudentDTO;
import com.raavana.student.repository.StudentOnboardingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentOnboardingService {

    private final StudentOnboardingRepository repository;

    public StudentDTO saveStudent(StudentDTO studentDTO) {
        StudentOnboardingEntity entity = StudentOnboardingEntity.builder()
                .userId(studentDTO.getUserId())
                .education(studentDTO.getEducation())
                .build();

        repository.save(entity);

        return studentDTO;
    }

}
