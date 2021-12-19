package com.academy.footballproject.controller;

import com.academy.footballproject.converter.PlayerConverter;
import com.academy.footballproject.dto.PlayerDto;
import com.academy.footballproject.model.Player;
import com.academy.footballproject.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/players")
public class PlayerController {
    private final PlayerService playerService;
    private final PlayerConverter playerConverter;

    public PlayerController(PlayerService playerService, PlayerConverter playerConverter) {
        this.playerService = playerService;
        this.playerConverter = playerConverter;
    }
    @GetMapping
    public ResponseEntity<Set<PlayerDto>> findAll() {
        return ResponseEntity.ok(playerService.findAll()
                .stream()
                .map(playerConverter::toPlayerDto)
                .collect(Collectors.toSet()));

    }
    @GetMapping
    public ResponseEntity<PlayerDto> save(@RequestBody @Valid PlayerDto playerDto) {
        Player player = playerConverter.toPlayer(playerDto);
        Player savedPlayer = playerService.save(player);
        return ResponseEntity.ok(playerConverter.toPlayerDto(savedPlayer));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<PlayerDto> update(@RequestBody @Valid PlayerDto playerDto,@PathVariable Long id){
        Player player = playerConverter.toPlayer(playerDto);
        Player updatePlayer = playerService.update(player,id);
        return ResponseEntity.ok(playerConverter.toPlayerDto(updatePlayer));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        playerService.delete(id);
        return ResponseEntity.ok().build();
    }

}


