package com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Service;

import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Entity.PlayerEntity;
import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Entity.PlayerProfileEntity;
import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<PlayerEntity> allPlayers() {
        return playerRepository.findAll();
    }

    public PlayerEntity getPlayer(int id){
        return playerRepository.findById(id).get();
    }

    public PlayerEntity addPlayer(PlayerEntity playerEntity) {
        playerEntity.setId(0);
        return playerRepository.save(playerEntity);
    }

    public void deletePlayer(int id) {
        playerRepository.deleteById(id);
    }

    public PlayerEntity assignProfile(int id, PlayerProfileEntity profile) {
        PlayerEntity playerEntity = playerRepository.findById(id).get();
        playerEntity.setPlayerProfile(profile);
        return playerRepository.save(playerEntity);
    }
}