package com.dentalsoft.finantialManagement.service;

import com.dentalsoft.finantialManagement.dto.SpentDto;
import com.dentalsoft.finantialManagement.entity.Spent;

import java.util.List;

public interface SpentService {
    Spent getById(Long id);

    SpentDto getSpentById(Long id);

    List<SpentDto> getAllValid();

    List<SpentDto> getAll(Long id);

    SpentDto create(SpentDto spentDto);

    SpentDto update(SpentDto spentDto);

    Void delete(Long id);
}
