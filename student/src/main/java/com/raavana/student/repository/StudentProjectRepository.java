package com.raavana.student.repository;
import com.raavana.student.entity.StudentProjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentProjectRepository extends MongoRepository<StudentProjectEntity, String> {
}

