package com.raavana.student.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "educationDetails")
public class StudentOnboardingEntity {
    @Id
        private String degree;
        private String specialization;
        private String institution;
        private Double cgpa;
        private Integer year;
        private String location;
    }


