package com.raavana.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="adminDetails")

public class OrganizationEntity {

    @Id
    private String id;
    private String organizationId;
    private String organizationName;
    private String organizationType;
    private String subdomain;
    private List<String> departments;
    private String location;
    private String website;

}
