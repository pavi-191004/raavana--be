package com.raavana.admin.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminEntity {
    private String name;
    private Integer age;
}
