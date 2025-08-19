package com.raavana.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @GetMapping("/get")
    public String getApi(){
        return "Getting API";
    }
}
