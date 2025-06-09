package com.dentalsoft.finantialManagement.mapper;

import com.dentalsoft.finantialManagement.dto.SpentDto;
import com.dentalsoft.finantialManagement.entity.Spent;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface SpentMapper {
    SpentMapper INSTANCE = Mappers.getMapper(SpentMapper.class);

    // Define mapping methods here, for example:
    Spent toEntity(SpentDto spentDto);

    SpentDto toDto(Spent spent);

    List<SpentDto> toDto(List<Spent> spents);
}
