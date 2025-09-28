package com.raavana.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Student")
@AllArgsConstructor
@NoArgsConstructor
public class EducationEntity {

    @Id
    private String id;
    private String studentId;
    private String degree;
    private String specialization;
    private String institution;
    private String cgpa;
    private int year;
    private String location;

}
