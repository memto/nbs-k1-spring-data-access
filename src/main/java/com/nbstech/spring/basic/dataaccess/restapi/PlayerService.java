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
    public PlayerEntity addPlayer(PlayerEntity p) {
        return playerRepository.save(p);
    }


    //Update a player
    public PlayerEntity updatePlayer(int id, PlayerEntity p) {
        Optional<PlayerEntity> playerEntityOpt = playerRepository.findById(id);

        if (playerEntityOpt.isEmpty())
            throw new RuntimeException("Player with id {"+ id +"} not found");
        else {
            PlayerEntity playerEntity = playerEntityOpt.get();

            //update player details
            playerEntity.setName(p.getName());
            playerEntity.setNationality(p.getNationality());
            playerEntity.setBirthDate(p.getBirthDate());
            playerEntity.setTitles(p.getTitles());

            return playerRepository.save(playerEntity);
        }
    }

    //Partial update

    //delete a player
}
