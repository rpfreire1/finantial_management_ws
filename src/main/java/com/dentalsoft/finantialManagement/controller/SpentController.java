package com.dentalsoft.finantialManagement.controller;

import com.dentalsoft.finantialManagement.dto.SpentDto;
import com.dentalsoft.finantialManagement.service.SpentService;
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
@RequestMapping("spent")
@Tag(name = "Spent", description = "API for managing spent")

public class SpentController {
    private final SpentService spentService;

    @GetMapping("all")
    @Operation(summary = "Get all spent", description = "Retrieve a list of all spent")
    public List<SpentDto> getAll() {
        log.info("{} : getAll", "Spent");
        return spentService.getAll();
    }

    @GetMapping
    @Operation(summary = "Get all valid spent", description = "Retrieve a list of all valid spent")
    public List<SpentDto> getAllValid() {
        log.info("{} : getAllValid", "Spent");
        return spentService.getAllValid();
    }

    @PostMapping
    @Operation(summary = "Create a new spent", description = "Create a new spent with schema: SpentDto")
    public SpentDto create(@RequestBody @Valid SpentDto spentDto) {
        log.info("{} : create, spentDto: {}", "Spent", spentDto);
        return spentService.create(spentDto);
    }

    @PutMapping
    @Operation(summary = "Update an existing spent", description = "Update an existing spent with schema: SpentDto")
    public SpentDto update(@RequestBody @Valid SpentDto spentDto) {
        log.info("{} : update, spentDto: {}", "Spent", spentDto);
        return spentService.update(spentDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a spent", description = "Delete a spent by its ID")
    public void delete(@PathVariable Long id) {
        log.info("{} : delete, id: {}", "Spent", id);
        spentService.delete(id);
    }
}
