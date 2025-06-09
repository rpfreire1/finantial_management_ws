package com.dentalsoft.finantialManagement.service;

import com.dentalsoft.finantialManagement.dto.SpentDto;
import com.dentalsoft.finantialManagement.entity.Spent;

import java.util.List;

public interface SpentService {
    Spent getSpentById(Long id);
    List<Spent> getAllValid();
    List<Spent> getAll(Long id);
    SpentDto create(SpentDto spentDto);
    SpentDto update(SpentDto spentDto);
    Void delete(Long id);
}
