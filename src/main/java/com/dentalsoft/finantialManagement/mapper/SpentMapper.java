package com.dentalsoft.finantialManagement.mapper;

import com.dentalsoft.finantialManagement.dto.SpentDto;
import com.dentalsoft.finantialManagement.entity.Spent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {SpentTypeMapper.class, SpentCategoryMapper.class})
public interface SpentMapper {
    SpentMapper INSTANCE = Mappers.getMapper(SpentMapper.class);

    // Define mapping methods here, for example:
    @Mapping(source = "spentDto.spentType", target = "spentType")
    @Mapping(source = "spentDto.spentCategory", target = "spentCategory")
    Spent toEntity(SpentDto spentDto);

    SpentDto toDto(Spent spent);

    List<SpentDto> toDto(List<Spent> spents);
}
