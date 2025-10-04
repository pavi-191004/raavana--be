package com.raavana.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="Admin")
@Builder
@AllArgsConstructor
public class UserEntity {
    private String name;
    private String email;
    private String type;
}
