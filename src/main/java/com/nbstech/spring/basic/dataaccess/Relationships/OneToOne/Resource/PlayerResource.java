package com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Resource;

import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Entity.PlayerEntity;
import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Entity.PlayerProfileEntity;
import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Service.PlayerProfileService;
import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerResource {
    @Autowired
    PlayerService playerService;

    @Autowired
    PlayerProfileService profileService;

    @GetMapping
    public List<PlayerEntity> allPlayers() {
        return playerService.allPlayers();
    }

    @GetMapping("/{id}")
    public PlayerEntity getPlayer(@PathVariable int id){
        return playerService.getPlayer(id);
    }

    @PostMapping
    public PlayerEntity addPlayer(@RequestBody PlayerEntity playerEntity) {
        return playerService.addPlayer(playerEntity);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
    }

    @PutMapping("/{id}/profiles/{profile_id}")
    public PlayerEntity assignDetail(@PathVariable int id, @PathVariable int profile_id) {
        PlayerProfileEntity profile = profileService.getPlayerProfile(profile_id);
        System.out.println(profile);
        return playerService.assignProfile(id, profile);
    }
}
