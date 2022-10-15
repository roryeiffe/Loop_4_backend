package com.revature.Loop.controllers;

import com.revature.Loop.entities.Player;
import com.revature.Loop.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @PostMapping()
    public Player addPlayer(@RequestBody Player player) {
        playerService.add(player);
        return player;
    }

    @GetMapping("/{id}")
    public Player getById(@PathVariable("id") Long id) {
        return playerService.getById(id);
    }

    @PutMapping("/{id}")
    public Player update(@PathVariable("id") Long id, @RequestBody Player player) {
        return playerService.update(id, player);
    }

    @PutMapping("/reset/{id}")
    public void reset(@PathVariable("id")Long id, @RequestBody boolean full) {
        playerService.reset(id, full);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        playerService.delete(id);
    }
}
