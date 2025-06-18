package com.dentalsoft.finantialManagement.service.impl;

import com.dentalsoft.finantialManagement.dto.SpentCategoryDto;
import com.dentalsoft.finantialManagement.entity.SpentCategory;
import com.dentalsoft.finantialManagement.entity.SpentType;
import com.dentalsoft.finantialManagement.mapper.SpentCategoryMapper;
import com.dentalsoft.finantialManagement.repository.SpentCategoryRepository;
import com.dentalsoft.finantialManagement.service.SpentCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpentCategoryServiceImpl implements SpentCategoryService {
    private final SpentCategoryRepository spentCategoryRepository;
    private final SpentCategoryMapper spentCategoryMapper;

    @Override
    public SpentCategory getById(Long id) {
        return spentCategoryRepository.getValidById(id).orElseThrow(() -> {
            log.error("SpentCategory with id {} not found", id);
            return new RuntimeException("SpentCategory not found");
        });
    }

    @Override
    public SpentCategoryDto getSpentCategoryById(Long id) {
        return spentCategoryMapper.toDto(spentCategoryRepository.getValidById(id).orElseThrow(() -> {
            log.error("SpentCategory with id {} not found", id);
            return new RuntimeException("SpentCategory not found");
        }));
    }

    @Override
    public List<SpentCategoryDto> getAllValid() {
        return this.spentCategoryMapper.toDto(spentCategoryRepository.getAllValid());
    }

    @Override
    public List<SpentCategoryDto> getAll() {
        return this.spentCategoryMapper.toDto(spentCategoryRepository.findAll());
    }

    @Override
    public SpentCategoryDto create(SpentCategoryDto categoryDto) {
        categoryDto.setId(null);
        return this.spentCategoryMapper.toDto(spentCategoryRepository.save(spentCategoryMapper.toEntity(categoryDto)));
    }

    @Override
    public SpentCategoryDto update(SpentCategoryDto categoryDto) {
        SpentCategory spentCategory=this.getById(categoryDto.getId());
        spentCategory.setName(categoryDto.getName());
        spentCategory.setDescription(categoryDto.getDescription());
        return this.spentCategoryMapper.toDto(spentCategoryRepository.save(spentCategory));
    }

    @Override
    public Void delete(Long id) {
        var spentCategory = this.getById(id);
        spentCategory.setDeletedAt(LocalDateTime.now());
        spentCategoryRepository.save(spentCategory);
        log.info("SpentCategory with id {} deleted successfully", id);
        return null;
    }
}
