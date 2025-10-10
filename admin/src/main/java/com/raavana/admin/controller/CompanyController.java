package com.raavana.admin.controller;
import com.raavana.admin.api.CompanyApi;
import com.raavana.admin.model.CompanyDTO;
import com.raavana.admin.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController implements CompanyApi{

    private final CompanyService companyService;


    @Override
    public ResponseEntity<CompanyDTO> add(CompanyDTO body) {
        return companyService.add(body);
    }

    @Override
    public ResponseEntity<String> delete(String id) {
        return companyService.delete(id);
    }

    @Override
    public ResponseEntity<List<CompanyDTO>> getAll() {
        return companyService.getAll();
    }

    @Override
    public ResponseEntity<CompanyDTO> getById(String id) {
        return companyService.getById(id);
    }

    @Override
    public ResponseEntity<CompanyDTO> update(String id, CompanyDTO body) {
        return companyService.update(id,body);
    }
}






