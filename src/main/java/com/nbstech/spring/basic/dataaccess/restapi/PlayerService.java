package com.nbstech.spring.basic.dataaccess.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
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
            throw new PlayerNotFoundException("Player with id "+ id + " not found.");
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
            throw new PlayerNotFoundException("Player with id {"+ id +"} not found");
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

    // Partial update
    public PlayerEntity patchPlayer( int id, Map<String, Object> partialPlayer) {
        Optional<PlayerEntity> playerEntityOpt = playerRepository.findById(id);

        if(playerEntityOpt.isPresent()) {
            PlayerEntity playerEntity = playerEntityOpt.get();

            partialPlayer.forEach( (key, value) -> {
                System.out.println("Key: " + key + " Value: " + value);
                Field field = ReflectionUtils.findField(PlayerEntity.class, key);
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, playerEntity, value);
            });

            return playerRepository.save(playerEntity);
        } else {
            throw new PlayerNotFoundException("Player with id {"+ id +"} not found");
        }
    }

    // Update a single field
    @Transactional
    public void updateTitles(int id, int titles) {
        Optional<PlayerEntity> tempPlayer = playerRepository.findById(id);

        if(tempPlayer.isEmpty())
            throw new PlayerNotFoundException("Player with id {"+ id +"} not found");

        playerRepository.updateTitles(id, titles);
    }

    // Delete a player
    public void deletePlayer(int id) {
        Optional<PlayerEntity> tempPlayer = playerRepository.findById(id);

        if(tempPlayer.isEmpty())
            throw new PlayerNotFoundException("Player with id {"+ id +"} not found");

        playerRepository.delete(tempPlayer.get());
    }
}
