package com.raavana.student.repository;

import com.raavana.student.entity.ExperiencesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExperiencesRepository extends MongoRepository<ExperiencesEntity,String> {
    List<ExperiencesEntity> findByStudentId(String id);
}
