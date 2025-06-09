package com.dentalsoft.finantialManagement.service.impl;

import com.dentalsoft.finantialManagement.dto.SpentCategoryDto;
import com.dentalsoft.finantialManagement.entity.Spent;
import com.dentalsoft.finantialManagement.entity.SpentCategory;
import com.dentalsoft.finantialManagement.mapper.SpentCategoryMapper;
import com.dentalsoft.finantialManagement.repository.SpentCategoryRepository;
import com.dentalsoft.finantialManagement.service.SpentCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpentCategoryServiceImpl implements SpentCategoryService {
    private final SpentCategoryRepository spentCategoryRepository;
    private final SpentCategoryMapper spentCategoryMapper;

    @Override
    public SpentCategory getById(Long id) {
        return spentCategoryRepository.getValidById(id).orElseThrow(()->{
            log.error("SpentCategory with id {} not found", id);
            return new RuntimeException("SpentCategory not found");
        });
    }

    @Override
    public SpentCategoryDto getSpentCategoryById(Long id) {
        return spentCategoryMapper.toDto(spentCategoryRepository.getValidById(id).orElseThrow(()->{
            log.error("SpentCategory with id {} not found", id);
            return new RuntimeException("SpentCategory not found");
        }));
    }

    @Override
    public List<SpentCategoryDto> getAllValid() {
        return this.spentCategoryMapper.toDto(spentCategoryRepository.getAllValid());
    }

    @Override
    public List<SpentCategoryDto> getAll(Long id) {
        return this.spentCategoryMapper.toDto(spentCategoryRepository.findAll());
    }

    @Override
    public SpentCategoryDto create(SpentCategoryDto categoryDto) {
        categoryDto.setId(null);
        return this.spentCategoryMapper.toDto(spentCategoryRepository.save(spentCategoryMapper.toEntity(categoryDto)));
    }

    @Override
    public SpentCategoryDto update(SpentCategoryDto categoryDto) {
        this.getById(categoryDto.getId());
        return this.spentCategoryMapper.toDto(spentCategoryRepository.save(spentCategoryMapper.toEntity(categoryDto)));
    }

    @Override
    public Void delete(Long id) {
        var spentCategory = this.getById(id);
        spentCategoryRepository.delete(spentCategory);
        log.info("SpentCategory with id {} deleted successfully", id);
        return null;
    }
}
