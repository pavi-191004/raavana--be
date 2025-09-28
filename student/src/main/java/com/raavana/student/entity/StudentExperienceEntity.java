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
public class StudentExperienceEntity {
    @Id
    private String id;
    private String role;
    private String companyName;
    private String startDate;
    private String endDate;
    private String mode;
    private String location;
    private String description;
}