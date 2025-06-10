package com.dentalsoft.finantialManagement.controller;

import com.dentalsoft.finantialManagement.dto.SpentTypeDto;
import com.dentalsoft.finantialManagement.service.SpentTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("spent-type")
@Tag(name = "Spent Type", description = "API for managing spent categories")
public class SpentTypeController {
    private final SpentTypeService spentTypeService;

    @GetMapping("all")
    @Operation(summary = "Get all spent categories", description = "Retrieve a list of all spent categories")
    public List<SpentTypeDto> getAll() {
        log.info("{} : getAll", "Spent-CATEGORY");
        return spentTypeService.getAll();
    }

    @GetMapping
    @Operation(summary = "Get all valid spent categories", description = "Retrieve a list of all valid spent categories")
    public List<SpentTypeDto> getAllValid() {
        log.info("{} : getAllValid", "Spent-CATEGORY");
        return spentTypeService.getAllValid();
    }

    @PostMapping
    @Operation(summary = "Create a new spent category", description = "Create a new spent category with schema: SpentTypeDto")
    public SpentTypeDto create(@RequestBody @Valid SpentTypeDto spentTypeDto) {
        log.info("{} : create, spentTypeDto: {}", "Spent-CATEGORY", spentTypeDto);
        return spentTypeService.create(spentTypeDto);
    }

    @PutMapping
    @Operation(summary = "Update an existing spent category", description = "Update an existing spent category with schema: SpentTypeDto")
    public SpentTypeDto update(@RequestBody @Valid SpentTypeDto spentTypeDto) {
        log.info("{} : update, spentTypeDto: {}", "Spent-CATEGORY", spentTypeDto);
        return spentTypeService.update(spentTypeDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a spent category", description = "Delete a spent category by its ID")
    public void delete(@PathVariable Long id) {
        log.info("{} : delete, id: {}", "Spent-CATEGORY", id);
        spentTypeService.delete(id);
    }
}
