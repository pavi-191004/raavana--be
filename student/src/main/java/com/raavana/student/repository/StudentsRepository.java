package com.raavana.student.repository;

import com.raavana.student.entity.StudentsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StudentsRepository extends MongoRepository<StudentsEntity , String>{
}
