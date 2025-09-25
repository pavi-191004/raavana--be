package com.raavana.admin.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminDto {

    private String name;
    private Integer age;
}