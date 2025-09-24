package com.raavana.admin.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "recruiterDetails")
public class RecruiterEntity{

    @Id
    private String id;
    private String name;
    private String designation;
    private String email;
    private String secondaryEmail;
    private String phoneNumber;
    private String mobileNumber;
    private String location;
    private String company;
    private String description;
    private String createdAt;
    private String createdBy;
    private String updatedAt;
    private String updatedBy;


}






