package com.dentalsoft.finantialManagement.service.impl;

import com.dentalsoft.finantialManagement.dto.SpentDto;
import com.dentalsoft.finantialManagement.entity.Spent;
import com.dentalsoft.finantialManagement.mapper.SpentMapper;
import com.dentalsoft.finantialManagement.repository.SpentRepository;
import com.dentalsoft.finantialManagement.repository.SpentTypeRepository;
import com.dentalsoft.finantialManagement.service.SpentCategoryService;
import com.dentalsoft.finantialManagement.service.SpentService;
import com.dentalsoft.finantialManagement.service.SpentTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpentServiceImpl implements SpentService {
    private final SpentRepository spentRepository;
    private final SpentMapper spentMapper;
    private final SpentTypeService spentTypeService;
    private final SpentCategoryService spentCategoryService;
    @Override
    public Spent getById(Long id) {
        return spentRepository.getValidById(id).orElseThrow(()->{
            log.error("Spent with id {} not found", id);
            return new RuntimeException("Spent not found");
        });
    }

    @Override
    public SpentDto getSpentById(Long id) {
        return spentMapper.toDto(spentRepository.getValidById(id).orElseThrow(()->{
            log.error("Spent with id {} not found", id);
            return new RuntimeException("Spent not found");
        }));    }

    @Override
    public List<SpentDto> getAllValid() {
        return this.spentMapper.toDto(spentRepository.getAllValid());    }

    @Override
    public List<SpentDto> getAll() {
        return this.spentMapper.toDto(spentRepository.findAll());
    }

    @Override
    public SpentDto create(SpentDto spentDto) {
        Spent spent=Spent.builder().build();
        spent=this.spentMapper.toEntity(spentDto);
        // Asegurarse de que es una nueva entidad
        spent.setSpentId(null);
        spent.setVersion(null);
        // Asignar las entidades relacionadas correctamente
        spent.setSpentType(spentTypeService.getById(spentDto.getSpentType().getId()));
        spent.setSpentCategory(spentCategoryService.getById(spentDto.getSpentCategory().getId()));
        System.out.printf("spent" + spent);
        this.spentRepository.save(spent);
        return  this.spentMapper.toDto(spent);
    }

    @Override
    public SpentDto update(SpentDto spentDto) {
        this.getById(spentDto.getSpentId());
        return this.spentMapper.toDto(spentRepository.save(spentMapper.toEntity(spentDto)));    }

    @Override
    public Void delete(Long id) {
        var spent = this.getById(id);
        spentRepository.delete(spent);
        log.info("SpentCategory with id {} deleted successfully", id);
        return null;    }
}
