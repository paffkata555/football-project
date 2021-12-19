package com.academy.footballproject.service;

import com.academy.footballproject.model.Team;
import org.apache.catalina.Manager;

import java.util.Set;

public interface TeamService {

    Set<Team>findAll();

    Team findById(Long id);

    Team save (Team team);
}
