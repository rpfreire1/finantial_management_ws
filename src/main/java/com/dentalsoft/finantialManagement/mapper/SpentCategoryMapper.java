package com.dentalsoft.finantialManagement.mapper;

import com.dentalsoft.finantialManagement.annotations.IgnoreAuditFields;
import com.dentalsoft.finantialManagement.dto.SpentCategoryDto;
import com.dentalsoft.finantialManagement.entity.SpentCategory;
import com.dentalsoft.finantialManagement.mapper.common.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpentCategoryMapper  {

    @IgnoreAuditFields
    SpentCategory toEntity(SpentCategoryDto spentCategoryDto);
    SpentCategoryDto toDto(SpentCategory spentCategory);
    List<SpentCategoryDto> toDto(List<SpentCategory> spentCategories);
}
