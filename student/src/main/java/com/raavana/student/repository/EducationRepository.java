package com.raavana.student.repository;

import com.raavana.student.entity.EducationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EducationRepository extends MongoRepository<EducationEntity, String> {
    List<EducationEntity> findByStudentId(String id);
}
