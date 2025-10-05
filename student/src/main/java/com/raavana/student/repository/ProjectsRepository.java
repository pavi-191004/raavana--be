package com.raavana.student.repository;

import com.raavana.student.entity.ProjectsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProjectsRepository extends MongoRepository<ProjectsEntity, String> {
    List<ProjectsEntity> findByStudentId(String id);
}
