package com.raavana.student.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Student")
public class StudentPersonalEntity {
    @Id
    private String id;
    private String profileImage;
    private String fullName;
    private String registerNo;
    private String degree;
    private String field;
    private String mobile;
    private String gender;
    private String domain;
    private String about;
}