package com.academy.footballproject.controller;

import com.academy.footballproject.converter.TeamConverter;
import com.academy.footballproject.dto.TeamDto;
import com.academy.footballproject.model.Team;
import com.academy.footballproject.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/teams")
public class TeamController {

    private final TeamService teamService;
    private final TeamConverter teamConverter;

    public TeamController(TeamService teamService, TeamConverter teamConverter) {
        this.teamService = teamService;
        this.teamConverter = teamConverter;
    }
    @PostMapping
    public ResponseEntity<TeamDto> save(@RequestBody TeamDto teamDto){
        Team team = teamConverter.toTeam(teamDto);
        Team savedTeam = teamService.save(team);
        TeamDto teamDto1= teamConverter.toTeamDto(savedTeam);
        return ResponseEntity.ok(teamDto1);
    }

    @GetMapping
    public ResponseEntity<TeamDto> findById(@PathVariable Long id){
        Team foundTeam = teamService.findById(id);
        TeamDto teamDto = teamConverter.toTeamDto(foundTeam);
        return ResponseEntity.ok(teamDto);
    }
}