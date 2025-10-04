package com.raavana.student.repository;

import com.raavana.student.entity.StudentPersonalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentPersonalRepository extends MongoRepository<StudentPersonalEntity,String> {

}