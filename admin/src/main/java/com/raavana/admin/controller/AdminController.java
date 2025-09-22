package com.raavana.admin.controller;


import com.raavana.admin.api.AddApi;
import com.raavana.admin.model.AdminDTO;
import lombok.RequiredArgsConstructor;
import com.raavana.admin.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController implements AddApi {

    private final AdminService adminService;
    @Override
    public ResponseEntity<AdminDTO> addPost(AdminDTO body) {

        return ResponseEntity.ok(adminService.addPost(body));
    }
}
