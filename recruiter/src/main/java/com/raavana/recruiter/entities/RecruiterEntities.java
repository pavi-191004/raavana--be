package com.raavana.recruiter.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "Recruiter")
public class RecruiterEntities {
    private String recruiterName;
    private Integer recruiterAge;
}
