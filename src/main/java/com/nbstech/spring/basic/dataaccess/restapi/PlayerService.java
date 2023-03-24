package com.nbstech.spring.basic.dataaccess.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    //Get all players
    public List<PlayerEntity> getAllPlayers() {
        return playerRepository.findAll();
    }

    //Get player by ID
    public PlayerEntity getPlayer(int id) {
        Optional<PlayerEntity> playerEntity = playerRepository.findById(id);

        if (playerEntity.isPresent()) {
            return playerEntity.get();
        } else {
            throw new RuntimeException("Player with id "+ id + " not found.");
        }
    }

    //Add a player

    //Update a player

    //Partial update

    //delete a player
}
