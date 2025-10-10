package com.raavana.admin.mapper;


import com.raavana.admin.entity.CompanyEntity;
import com.raavana.admin.model.CompanyDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyMapper {
    private final ModelMapper modelMapper;

    public CompanyEntity dtoToEntity(CompanyDTO dto) {
        return modelMapper.map(dto, CompanyEntity.class);
    }

    public CompanyDTO entityToDto(CompanyEntity entity) {
        return modelMapper.map(entity, CompanyDTO.class);
    }

    public void updateEntityFromDto(CompanyDTO dto, CompanyEntity entity) {
        modelMapper.typeMap(CompanyDTO.class, CompanyEntity.class).addMappings(mapper -> mapper.skip(CompanyEntity::setId));
        modelMapper.map(dto, entity);
    }


}
