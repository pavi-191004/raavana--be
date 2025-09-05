package com.raavana.thirdparty.controller;

import com.raavana.thirdparty.api.HiApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ThirdPartyController implements HiApi {

    @Override
    public ResponseEntity<String> hiGet() {
        return ResponseEntity.ok("hi from thirdParty service ");
    }
}