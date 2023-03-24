package com.nbstech.spring.basic.dataaccess.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
