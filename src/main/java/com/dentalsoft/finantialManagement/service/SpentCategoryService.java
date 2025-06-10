package com.dentalsoft.finantialManagement.service;

import com.dentalsoft.finantialManagement.dto.SpentCategoryDto;
import com.dentalsoft.finantialManagement.entity.SpentCategory;

import java.util.List;

public interface SpentCategoryService {
    SpentCategory getById(Long id);

    SpentCategoryDto getSpentCategoryById(Long id);

    List<SpentCategoryDto> getAllValid();

    List<SpentCategoryDto> getAll();

    SpentCategoryDto create(SpentCategoryDto categoryDto);

    SpentCategoryDto update(SpentCategoryDto categoryDto);

    Void delete(Long id);
}
