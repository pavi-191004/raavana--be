package com.raavana.admin.service;


import com.raavana.admin.entity.SubDomainEntity;
import com.raavana.admin.repository.SubDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class SubDomainService {

    @Autowired
    private final SubDomainRepository subDomainRepository;

    public boolean isSubDomainAvailable(String id){
        Optional<SubDomainEntity> subDomain = subDomainRepository.findById(id);
        return subDomain.isPresent();
    }
}