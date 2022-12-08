package com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Resource;

import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Entity.PlayerProfileEntity;
import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Service.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player-profiles")
public class PlayerProfileResource {
    @Autowired
    PlayerProfileService playerProfileService;

    @GetMapping
    public List<PlayerProfileEntity> allPlayerProfiles() {
        return playerProfileService.allPlayerProfiles();
    }

    @GetMapping("/{id}")
    public PlayerProfileEntity getPlayerProfile(@PathVariable int id){
        return playerProfileService.getPlayerProfile(id);
    }

    @PostMapping
    public PlayerProfileEntity addPlayerProfile(@RequestBody PlayerProfileEntity playerProfileEntity) {
        return playerProfileService.addPlayerProfile(playerProfileEntity);
    }

    @DeleteMapping("/{id}")
    public void deletePlayerProfile(@PathVariable int id) {
        playerProfileService.deletePlayerProfile(id);
    }
}
