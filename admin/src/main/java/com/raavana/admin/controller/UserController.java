package com.raavana.admin.controller;


import com.raavana.admin.api.AuthApi;
import com.raavana.admin.model.UserDTO;
import com.raavana.admin.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class UserController implements AuthApi {

    private final UserService userService;

    @Override
    public ResponseEntity<String> authEnrollPost(UserDTO body) {
        return ResponseEntity.ok(userService.authEnroll(body));
    }
}
