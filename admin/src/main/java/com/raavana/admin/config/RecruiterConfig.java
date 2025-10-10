package com.raavana.admin.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RecruiterConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
