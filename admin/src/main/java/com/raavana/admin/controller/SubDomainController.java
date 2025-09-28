package com.raavana.admin.controller;

import com.raavana.admin.api.VerifyDomainApi;
import com.raavana.admin.service.SubDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class SubDomainController implements VerifyDomainApi {

    @Autowired
    private final SubDomainService subDomainService;


    @Override
    public ResponseEntity<String> verifyDomainIdGet(String id) {
        boolean exists = subDomainService.isSubDomainAvailable(id);

        if(exists){
            return ResponseEntity.ok("Subdomain available");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subdomain not available");
        }
    }
}



