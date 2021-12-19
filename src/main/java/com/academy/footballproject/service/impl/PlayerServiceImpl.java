package com.academy.footballproject.service.impl;

import com.academy.footballproject.exception.DuplicateResourceException;
import com.academy.footballproject.exception.ResourceNotFoundException;
import com.academy.footballproject.model.Player;
import com.academy.footballproject.repository.PlayerRepository;
import com.academy.footballproject.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public Set<Player> findAll() {
        return new TreeSet<>(playerRepository.findAll());
    }

    public Player save(Player player) {
        try {
            return playerRepository.save(player);
        }catch (DataIntegrityViolationException exception){
            throw new DuplicateResourceException(String.format("Player with number %d already exists.",player.getNumber()));
        }

    }


    public Player findById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Player with %d id does not exists.",id)));
    }


    public Player findByNumber(Integer number) {
        return playerRepository.findByNumber(number)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Player with %d number does not exists.",number)));
    }


    public Player update(Player player, Long id) {
        Player foundPlayer = findById(id);
        Player updatedPlayer = Player.builder()
                .id(foundPlayer.getId())
                .number(foundPlayer.getNumber())
                .name(foundPlayer.getName())
                .position(foundPlayer.getPosition())
                .build();

        return save(updatedPlayer);
    }


    public void delete(Long id) {
        playerRepository.deleteById(id);

    }
}
