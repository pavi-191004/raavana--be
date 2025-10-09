package com.raavana.admin.mapper;

import com.raavana.admin.entity.RecruiterEntity;
import com.raavana.admin.model.RecruiterDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecruiterMapper {
    private final ModelMapper modelMapper;

    public RecruiterEntity dtoToEntity(RecruiterDTO dto) {
        return modelMapper.map(dto, RecruiterEntity.class);
    }

    public RecruiterDTO entityToDto(RecruiterEntity entity) {
        return modelMapper.map(entity, RecruiterDTO.class);
    }

    public void updateEntityFromDto(RecruiterDTO dto, RecruiterEntity entity){
        modelMapper.typeMap(RecruiterDTO.class, RecruiterEntity.class)
                .addMappings(mapper -> mapper.skip(RecruiterEntity::setId));
        modelMapper.map(dto, entity);

    }
}
