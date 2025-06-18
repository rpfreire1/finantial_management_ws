package com.dentalsoft.finantialManagement.service.impl;

import com.dentalsoft.finantialManagement.dto.SpentTypeDto;
import com.dentalsoft.finantialManagement.entity.SpentType;
import com.dentalsoft.finantialManagement.mapper.SpentTypeMapper;
import com.dentalsoft.finantialManagement.repository.SpentTypeRepository;
import com.dentalsoft.finantialManagement.service.SpentTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpentTypeServiceImpl implements SpentTypeService {
    private final SpentTypeRepository spentTypeRepository;
    private final SpentTypeMapper spentTypeMapper;

    @Override
    public SpentType getById(Long id) {
        return this.spentTypeRepository.getValidById(id).orElseThrow(() -> {
            log.error("SpentType with id {} not found", id);
            return new RuntimeException("SpentType not found");
        });
    }

    @Override
    public SpentTypeDto getSpentTypeById(Long id) {
        return spentTypeMapper.toDto(spentTypeRepository.getValidById(id).orElseThrow(() -> {
            log.error("SpentType with id {} not found", id);
            return new RuntimeException("SpentType not found");
        }));
    }

    @Override
    public List<SpentTypeDto> getAllValid() {
        return this.spentTypeMapper.toDto(spentTypeRepository.getAllValid());
    }

    @Override
    public List<SpentTypeDto> getAll() {
        return this.spentTypeMapper.toDto(spentTypeRepository.findAll());
    }

    @Override
    public SpentTypeDto create(SpentTypeDto spentTypeDto) {
        spentTypeDto.setId(null);
        return this.spentTypeMapper.toDto(spentTypeRepository.save(spentTypeMapper.toEntity(spentTypeDto)));
    }

    @Override
    public SpentTypeDto update(SpentTypeDto spentTypeDto) {
        SpentType spentType=this.getById(spentTypeDto.getId());
        spentType.setName(spentTypeDto.getName());
        spentType.setDescription(spentTypeDto.getDescription());
        return this.spentTypeMapper.toDto(spentTypeRepository.save(spentType));
    }
    @Override
    public void delete(Long id) {
        var spentType = this.getById(id);
        spentType.setDeletedAt(LocalDateTime.now());
        spentTypeRepository.save(spentType);
        log.info("SpentType with id {} deleted successfully", id);
    }
}
