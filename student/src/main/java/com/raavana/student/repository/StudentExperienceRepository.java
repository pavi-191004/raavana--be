package com.raavana.student.repository;

import com.raavana.student.entity.StudentExperienceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentExperienceRepository extends MongoRepository<StudentExperienceEntity,String> {
}
