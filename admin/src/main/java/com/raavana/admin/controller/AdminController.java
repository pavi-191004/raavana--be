package com.raavana.admin.controller;

import com.raavana.admin.dto.AdminDto;
import com.raavana.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.raavana.admin.api.HiApi;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AdminController implements HiApi{

    private  final AdminService adminService;
        @Override
        public ResponseEntity<String> hiGet() {
            return ResponseEntity.ok("Hello from Admin Service!");
        }
    @PostMapping("/app")
    public void addStudent(@RequestBody AdminDto adminDto) {
        adminService.addStudent(adminDto);
    }

}
