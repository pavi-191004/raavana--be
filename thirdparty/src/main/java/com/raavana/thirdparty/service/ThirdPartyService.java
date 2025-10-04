package com.raavana.thirdparty.service;

import com.raavana.thirdparty.entity.ThirdPartyEntity;
import com.raavana.thirdparty.model.ThirdPartyDTO;
import com.raavana.thirdparty.repository.ThirdPartyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ThirdPartyService {
    private final ThirdPartyRepository thirdPartyRepository;

    public ThirdPartyDTO addPost(ThirdPartyDTO thirdPartyDTO){
        ThirdPartyEntity thirdPartyEntity=ThirdPartyEntity.builder()
                .name(thirdPartyDTO.getName())
                .age(thirdPartyDTO.getAge())
                .build();
        ThirdPartyEntity saveEntity=thirdPartyRepository.save(thirdPartyEntity);
        return thirdPartyDTO;
    }
}

