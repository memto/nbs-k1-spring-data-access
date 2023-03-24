package com.nbstech.spring.basic.dataaccess.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Tennis Player REST API";
    }

    @GetMapping("/players")
    public List<PlayerEntity> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public PlayerEntity getPlayer(@PathVariable int id) {
        return playerService.getPlayer(id);
    }

    @PostMapping("/players")
    public PlayerEntity createPlayer(@RequestBody PlayerEntity p) {
//        p.setId(0);
        return playerService.addPlayer(p);
    }

    @PutMapping("/players/{id}")
    public PlayerEntity updatePlayer(@PathVariable int id, @RequestBody PlayerEntity p) {
        return playerService.updatePlayer(id, p);
    }

    @PatchMapping("/players/{id}")
    public PlayerEntity partialUpdate(@PathVariable int id, @RequestBody Map<String, Object> playerPatch) {
        return playerService.patchPlayer(id, playerPatch);
    }

    @PatchMapping("/players/{id}/titles")
    public void updateTitles(@PathVariable int id, @RequestBody int titles) {
        playerService.updateTitles(id, titles);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
    }

}
