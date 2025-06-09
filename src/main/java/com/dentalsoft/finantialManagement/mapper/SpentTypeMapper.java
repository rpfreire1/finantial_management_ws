package com.dentalsoft.finantialManagement.mapper;

import com.dentalsoft.finantialManagement.dto.SpentTypeDto;
import com.dentalsoft.finantialManagement.entity.SpentType;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface SpentTypeMapper {
    SpentTypeMapper INSTANCE = Mappers.getMapper(SpentTypeMapper.class);

    // Define mapping methods here, for example:
    SpentType toEntity(SpentTypeDto spentTypeDto);

    SpentTypeDto toDto(SpentType spentType);

    List<SpentTypeDto> toDto(List<SpentType> spentTypes);

}
