package com.raavana.admin.service;

import com.raavana.admin.dto.AdminDto;
import com.raavana.admin.entity.AdminEntity;
import com.raavana.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public void addStudent(AdminDto adminDto) {
        System.out.println("request reached" +  adminDto);

        AdminEntity studentEntity = AdminEntity.builder().name( adminDto.getName()).age( adminDto.getAge()).build();
        adminRepository.save(studentEntity);

    }
}
