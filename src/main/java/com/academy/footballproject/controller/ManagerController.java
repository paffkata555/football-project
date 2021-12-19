package com.academy.footballproject.controller;

import com.academy.footballproject.converter.ManagerConverter;
import com.academy.footballproject.dto.ManagerDto;
import com.academy.footballproject.dto.PlayerDto;
import com.academy.footballproject.model.Manager;
import com.academy.footballproject.model.Player;
import com.academy.footballproject.service.ManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/managers")
public class ManagerController {

    private final ManagerService managerService;
    private final ManagerConverter managerConverter;

    public ManagerController(ManagerService managerService, ManagerConverter managerConverter) {
        this.managerService = managerService;
        this.managerConverter = managerConverter;
    }
}
