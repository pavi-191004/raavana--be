package com.raavana.student.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Student")
public class StudentProjectEntity {

    @Id
    private String id;
    private String name;
    private String startDate;
    private String endDate;
    private String description;
    private String technologies;
}

