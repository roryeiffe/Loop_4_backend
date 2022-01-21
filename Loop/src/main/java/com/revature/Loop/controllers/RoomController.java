package com.revature.Loop.controllers;

import com.revature.Loop.dto.RoomUserIds;
import com.revature.Loop.services.RoomService;
import com.revature.Loop.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping("")
    public Room addRoom() {
        return roomService.addRoom();
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

    @PutMapping("/init/{id}")
    public Room initializeRoom(@PathVariable("id") Long id) {
        return roomService.initializeRoom(id);
    }

    @PutMapping("/addUser")
    public Room addUser(@RequestBody RoomUserIds data) {
        return roomService.addUser(data);
    }

}
