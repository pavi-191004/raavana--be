package com.raavana.student.repository;

import com.raavana.student.entity.SkillsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SkillsRepository extends MongoRepository<SkillsEntity, String> {
    List<SkillsEntity> findByStudentId(String id);
}
