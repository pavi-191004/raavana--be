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
public class ExperiencesEntity {

    @Id
    private String id;
    private String studentId;
    private String role;
    private String companyName;
    private String startDate;
    private String endDate;
    private String mode;
    private String location;
    private String description;

}
