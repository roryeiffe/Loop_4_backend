package com.revature.Loop.controllers;

import com.revature.Loop.Exceptions.NotEnoughPlayersException;
import com.revature.Loop.services.RoomService;
import com.revature.Loop.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping("")
    public Room addRoom() {
        return roomService.addRoom();
    }

    @PostMapping("{roomId}/players/{playerId}")
    public Room addPlayer(@PathVariable("roomId") Long roomId, @PathVariable("playerId") Long playerId) {
        return roomService.addPlayer(roomId, playerId);
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable("id") Long id) {
        return roomService.getRoom(id);
    }

    @GetMapping("/password/{password}")
    public Room getRoomByPassword(@PathVariable("password") String password) {
        return roomService.getRoomByPassword(password);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable("id") Long id) {
        roomService.deleteRoom(id);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable("id") Long id, @RequestBody Room room) {
        return roomService.updateRoom(id, room);
    }

    @PatchMapping("/{id}")
    public Room initializeRoom(@PathVariable("id") Long id) throws NotEnoughPlayersException {
        return roomService.initializeRoom(id);
    }


}
