package com.dentalsoft.finantialManagement.service;

import com.dentalsoft.finantialManagement.dto.SpentTypeDto;
import com.dentalsoft.finantialManagement.entity.SpentType;

import java.util.List;

public interface SpentTypeService {
    SpentType getById(Long id);
    SpentTypeDto getSpentTypeById(Long id);
    List<SpentTypeDto> getAllValid();
    List<SpentTypeDto> getAll();
    SpentTypeDto create(SpentTypeDto spentTypeDto);
    SpentTypeDto update(SpentTypeDto spentTypeDto);
    void delete(Long id);
}
