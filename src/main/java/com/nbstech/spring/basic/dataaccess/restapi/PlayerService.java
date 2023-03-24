package com.nbstech.spring.basic.dataaccess.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    //Get all players
    public List<PlayerEntity> getAllPlayers() {
        return playerRepository.findAll();
    }

    //Get player by ID

    //Add a player

    //Update a player

    //Partial update

    //delete a player
}
