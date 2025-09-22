package com.raavana.admin.service;


import com.raavana.admin.entity.AdminEntity;
import com.raavana.admin.model.AdminDTO;
import com.raavana.admin.repository.AdminRepository;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AdminService  {
    private final AdminRepository adminRepository;

     public AdminDTO addPost(AdminDTO adminDTO){
         AdminEntity adminEntity= AdminEntity.builder()
                 .AdminName(adminDTO.getAdminName())
                 .AdminAge(adminDTO.getAdminAge())
                 .build();
         AdminEntity saveEntity = adminRepository.save(adminEntity);
         return adminDTO;
     }


    }

