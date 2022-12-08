package com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Resource;

import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Entity.Player;
import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Entity.PlayerProfile;
import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Service.PlayerProfileService;
import com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerResource {
    @Autowired
    PlayerService service;

    @Autowired
    PlayerProfileService profileService;

    @GetMapping
    public List<Player> allPlayers() {
        return service.allPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable int id){
        return service.getPlayer(id);
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return service.addPlayer(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable int id) {
        service.deletePlayer(id);
    }

    @PutMapping("/{id}/profiles/{profile_id}")
    public Player assignDetail(@PathVariable int id, @PathVariable int profile_id) {
        PlayerProfile profile = profileService.getPlayerProfile(profile_id);
        System.out.println(profile);
        return service.assignProfile(id, profile);
    }
}
