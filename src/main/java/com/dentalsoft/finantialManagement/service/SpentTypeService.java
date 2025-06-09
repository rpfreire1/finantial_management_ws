package com.dentalsoft.finantialManagement.service;

import com.dentalsoft.finantialManagement.dto.SpentTypeDto;
import com.dentalsoft.finantialManagement.entity.SpentType;

import java.util.List;

public interface SpentTypeService {
    SpentType getSpentTypeById(Long id);
    List<SpentType> getAllValid();
    List<SpentType> getAll(Long id);
    SpentTypeDto create(SpentTypeDto spentTypeDto);
    SpentTypeDto update(SpentTypeDto spentTypeDto);
    Void delete(Long id);
}
