package com.raavana.student.service;

import com.raavana.student.entity.StudentExperienceEntity;
import com.raavana.student.model.StudentExperienceDTO;
import com.raavana.student.repository.StudentExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentExperienceService {

    @Autowired
    private final StudentExperienceRepository experienceRepository;

    public String addExperience(StudentExperienceDTO body) {
        StudentExperienceEntity experienceEntity = StudentExperienceEntity.builder()
                .role(body.getRole())
                .companyName(body.getCompanyName())
                .startDate(body.getStartDate())
                .endDate(body.getEndDate())
                .mode(body.getMode())
                .location(body.getLocation())
                .description(body.getDescription()).build();
        experienceRepository.save(experienceEntity);
        return "Student Experience Details Created";
    }

    public String updateExperience(String id, StudentExperienceDTO body) {
        StudentExperienceEntity experienceEntity = experienceRepository.findById(id).orElseThrow(()->new RuntimeException("Student Not Found: "+id));
        StudentExperienceEntity updateEntity = StudentExperienceEntity.builder()
                .id(experienceEntity.getId())
                .role(body.getRole())
                .companyName(body.getCompanyName())
                .startDate(body.getStartDate())
                .endDate(body.getEndDate())
                .mode(body.getMode())
                .location(body.getLocation())
                .description(body.getDescription()).build();
        experienceRepository.save(updateEntity);
        return "Student Experience Details Updated";

    }

    public String deleteExperience(String id) {
        experienceRepository.deleteById(id);
        return "Student Experience details deleted";
    }
}
