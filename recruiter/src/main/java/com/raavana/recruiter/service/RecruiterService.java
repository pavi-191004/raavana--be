package com.raavana.recruiter.service;

import com.raavana.recruiter.entities.RecruiterEntities;
import com.raavana.recruiter.model.RecruiterDTO;
import com.raavana.recruiter.repository.RecruiterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruiterService {
    private final RecruiterRepository recruiterRepository;

    public RecruiterDTO addPost(RecruiterDTO recruiterDTO){
        RecruiterEntities recruiterEntities=RecruiterEntities.builder()
                .recruiterName(recruiterDTO.getRecruiterName())
                .recruiterAge(recruiterDTO.getRecruiterAge())
                .build();
         RecruiterEntities saveEntity=recruiterRepository.save(recruiterEntities);
         return recruiterDTO;

    }
}
