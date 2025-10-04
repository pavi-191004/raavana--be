package com.raavana.thirdparty.controller;


import com.raavana.thirdparty.api.AddApi;
import com.raavana.thirdparty.model.ThirdPartyDTO;
import com.raavana.thirdparty.service.ThirdPartyService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ThirdPartyController implements AddApi {

     private final ThirdPartyService thirdPartyService;
    @Override
    public ResponseEntity<ThirdPartyDTO> addPost(ThirdPartyDTO body) {
        return ResponseEntity.ok(thirdPartyService.addPost(body));
    }
}