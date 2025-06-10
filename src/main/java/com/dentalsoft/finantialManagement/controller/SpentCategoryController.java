package com.dentalsoft.finantialManagement.controller;

import com.dentalsoft.finantialManagement.dto.SpentCategoryDto;
import com.dentalsoft.finantialManagement.service.SpentCategoryService;
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
@RequestMapping("spent-category")
@Tag(name = "Spent Category", description = "API for managing spent categories")
public class SpentCategoryController {
    private final SpentCategoryService spentCategoryService;

    @GetMapping("all")
    @Operation(summary = "Get all spent categories", description = "Retrieve a list of all spent categories")
    public List<SpentCategoryDto> getAll() {
        log.info("{} : getAll", "Spent-CATEGORY");
        return spentCategoryService.getAll();
    }

    @GetMapping
    @Operation(summary = "Get all valid spent categories", description = "Retrieve a list of all valid spent categories")
    public List<SpentCategoryDto> getAllValid() {
        log.info("{} : getAllValid", "Spent-CATEGORY");
        return spentCategoryService.getAllValid();
    }

    @PostMapping
    @Operation(summary = "Create a new spent category", description = "Create a new spent category with schema: SpentCategoryDto")
    public SpentCategoryDto create(@RequestBody @Valid SpentCategoryDto spentCategoryDto) {
        log.info("{} : create, spentCategoryDto: {}", "Spent-CATEGORY", spentCategoryDto);
        return spentCategoryService.create(spentCategoryDto);
    }

    @PutMapping
    @Operation(summary = "Update an existing spent category", description = "Update an existing spent category with schema: SpentCategoryDto")
    public SpentCategoryDto update(@RequestBody @Valid SpentCategoryDto spentCategoryDto) {
        log.info("{} : update, spentCategoryDto: {}", "Spent-CATEGORY", spentCategoryDto);
        return spentCategoryService.update(spentCategoryDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a spent category", description = "Delete a spent category by its ID")
    public void delete(@PathVariable Long id) {
        log.info("{} : delete, id: {}", "Spent-CATEGORY", id);
        spentCategoryService.delete(id);
    }
}
