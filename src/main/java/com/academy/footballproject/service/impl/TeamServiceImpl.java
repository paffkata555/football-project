package com.academy.footballproject.service.impl;

import com.academy.footballproject.exception.ResourceNotFoundException;
import com.academy.footballproject.model.Player;
import com.academy.footballproject.model.Team;
import com.academy.footballproject.repository.TeamRepository;
import com.academy.footballproject.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }



    @Override
    public Set<Team> findAll() {
        return null;
    }

    @Override
    public Team findById(Long id) {
        return teamRepository.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException(String.format("Player with %d id does not exists.",id)));

    }

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }
}
