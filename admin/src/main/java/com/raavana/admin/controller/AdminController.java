package com.raavana.admin.controller;

import org.springframework.http.ResponseEntity;
import com.raavana.admin.api.HiApi;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AdminController implements HiApi{



        @Override
        public ResponseEntity<String> hiGet() {
            return ResponseEntity.ok("Hello from Admin Service!");
        }


}
