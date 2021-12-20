package com.academy.footballproject.converter;

import com.academy.footballproject.dto.TeamDto;
import com.academy.footballproject.model.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamConverter {
    public TeamDto toTeamDto(Team team){
        return TeamDto.builder()
                .id(team.getId())
                .name(team.getName())
                .build();

    }
    public Team toTeam(TeamDto teamDto){
        return Team.builder()
                .id(teamDto.getId())
                .name(teamDto.getName())
                .build();
    }
}
