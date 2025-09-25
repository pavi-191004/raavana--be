package com.raavana.student.service;

import com.raavana.student.entity.StudentOnboardingEntity;
import com.raavana.student.model.StudentDTO;
import com.raavana.student.repository.StudentOnboardingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.st;

@Service
@AllArgsConstructor
public class StudentOnboardingService {
    private final StudentOnboardingRepository studentOnboardingRepository;

    public StudentDTO studentPost(StudentDTO studentDTO) {
        StudentOnboardingEntity studentOnboardingEntity = StudentOnboardingEntity.builder()

                .degree(studentDTO.getDegree())
                .institution(studentDTO.getInstitution())
                .specialization(studentDTO.getSpecialization())
                .cgpa(studentDTO.getCgpa())
                .year(studentDTO.getYear())
                .location(studentDTO.getLocation())
                .build();

        StudentOnboardingEntity savedEntity = studentOnboardingRepository.save(studentOnboardingEntity);

        StudentDTO savedDTO = new StudentDTO();

        savedDTO.setDegree(savedEntity.getDegree());
        savedDTO.setInstitution(savedEntity.getInstitution());
        savedDTO.setSpecialization(savedEntity.getSpecialization());
        savedDTO.setCgpa(savedEntity.getCgpa());
        savedDTO.setYear(savedEntity.getYear());
        savedDTO.setLocation(savedEntity.getLocation());

        return savedDTO;



    }

}
