package com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Service;

import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Entity.PlayerProfileEntity;
import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Repository.PlayerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerProfileService {

    @Autowired
    PlayerProfileRepository playerProfileRepository;

    public List<PlayerProfileEntity> allPlayerProfiles() {
        return playerProfileRepository.findAll();
    }

    public PlayerProfileEntity getPlayerProfile(int id){
        return playerProfileRepository.findById(id).get();
    }

    public PlayerProfileEntity addPlayerProfile(PlayerProfileEntity profile) {
        profile.setId(0);
        return playerProfileRepository.save(profile);
    }

    public void deletePlayerProfile(int id) {
        playerProfileRepository.deleteById(id);
    }
}