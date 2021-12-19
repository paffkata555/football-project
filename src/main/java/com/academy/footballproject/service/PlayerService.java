package com.academy.footballproject.service;

import com.academy.footballproject.model.Player;

import java.util.Set;

public interface PlayerService {

    Player save(Player player);

    Player findById(Long id);

    Player findByNumber(Integer number);

    Player update(Player player,Long id);

    void delete(Long id);

    Set<Player> findAll();
}
