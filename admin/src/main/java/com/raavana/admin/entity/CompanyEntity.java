package com.raavana.admin.entity;

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
@Document(value= "companiesDetails")
public class CompanyEntity {

    @Id
    private String id;
    private String companyName;
    private String location;
    private String industry;
    private String website;
    private String specialities;
    private String description;
    private String createdAt;
    private String createdBy;
    private String updatedAt;
    private String updatedBy;

}
