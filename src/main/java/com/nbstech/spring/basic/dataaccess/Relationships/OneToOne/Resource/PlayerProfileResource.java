package com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Resource;

import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Entity.PlayerProfile;
import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Service.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player-profiles")
public class PlayerProfileResource {
    @Autowired
    PlayerProfileService service;

    @GetMapping
    public List<PlayerProfile> allPlayerProfiles() {
        return service.allPlayerProfiles();
    }

    @GetMapping("/{id}")
    public PlayerProfile getPlayerProfile(@PathVariable int id){
        return service.getPlayerProfile(id);
    }

    @PostMapping
    public PlayerProfile addPlayerProfile(@RequestBody PlayerProfile playerProfile) {
        return service.addPlayerProfile(playerProfile);
    }

    @DeleteMapping("/{id}")
    public void deletePlayerProfile(@PathVariable int id) {
        service.deletePlayerProfile(id);
    }
}
