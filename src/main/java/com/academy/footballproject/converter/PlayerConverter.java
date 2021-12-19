package com.academy.footballproject.converter;

import com.academy.footballproject.dto.PlayerDto;
import com.academy.footballproject.model.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerConverter {

    public PlayerDto toPlayerDto(Player player){
        return PlayerDto.builder()
                .id(player.getId())
                .number(player.getNumber())
                .build();

    }
    public Player toPlayer(PlayerDto playerDto){
        return Player.builder()
                .id(playerDto.getId())
                .number(playerDto.getNumber())
                .build();
    }}
