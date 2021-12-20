package com.academy.footballproject.controller;

import com.academy.footballproject.converter.ManagerConverter;
import com.academy.footballproject.dto.ManagerDto;
import com.academy.footballproject.model.Manager;
import com.academy.footballproject.service.ManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/managers")
public class ManagerController {

    private final ManagerService managerService;
    private final ManagerConverter managerConverter;

    public ManagerController(ManagerService managerService, ManagerConverter managerConverter) {
        this.managerService = managerService;
        this.managerConverter = managerConverter;

    }

    @GetMapping
    public ResponseEntity<Set<ManagerDto>> findAll() {
        return ResponseEntity.ok(managerService.findAll()
                .stream()
                .map(managerConverter::toManagerDto)
                .collect(Collectors.toSet()));

    }

    @GetMapping
    public ResponseEntity<ManagerDto> save(@RequestBody @Valid ManagerDto managerDto) {
        Manager manager = managerConverter.toManager(managerDto);
        Manager savedManager = managerService.save(manager);
        return ResponseEntity.ok(managerConverter.toManagerDto(savedManager));
    }
}
