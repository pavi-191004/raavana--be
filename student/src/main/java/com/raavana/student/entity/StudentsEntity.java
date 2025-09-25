package com.raavana.student.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "skillsDetails")
public class StudentsEntity {

    @Id
    private String id;

    private List<String> technicalSkills;
    private List<String> softSkills;
    private List<String> hobbies;
}