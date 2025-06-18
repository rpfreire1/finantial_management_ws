package com.dentalsoft.finantialManagement.mapper;

import com.dentalsoft.finantialManagement.annotations.IgnoreAuditFields;
import com.dentalsoft.finantialManagement.dto.SpentCategoryDto;
import com.dentalsoft.finantialManagement.dto.SpentTypeDto;
import com.dentalsoft.finantialManagement.entity.SpentCategory;
import com.dentalsoft.finantialManagement.entity.SpentType;
import com.dentalsoft.finantialManagement.mapper.common.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface SpentTypeMapper extends EntityMapper<SpentType, SpentTypeDto> {

    @IgnoreAuditFields
    // Define mapping methods here, for example:
    SpentType toEntity(SpentTypeDto spentTypeDto);

    SpentTypeDto toDto(SpentType spentType);

    List<SpentTypeDto> toDto(List<SpentType> spentTypes);

}
