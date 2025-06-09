package com.dentalsoft.finantialManagement.mapper;

import com.dentalsoft.finantialManagement.dto.SpentCategoryDto;
import com.dentalsoft.finantialManagement.entity.SpentCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpentCategoryMapper {
 SpentCategoryMapper INSTANCE = Mappers.getMapper(SpentCategoryMapper.class);
    // Define mapping methods here, for example:
    SpentCategory toEntity(SpentCategoryDto spentCategoryDto);
    SpentCategoryDto toDto(SpentCategory spentCategory);
    List<SpentCategoryDto> toDto(List<SpentCategory> spentCategories);
}
