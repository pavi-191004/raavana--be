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
public class PersonalEntity {

    @Id
    private String id;
    private String studentImage;
    private String fullName;
    private String registerNo;
    private String degree;
    private String fieldOfStudy;
    private String phone;
    private String gender;
    private String domain;
    private String about;

}
