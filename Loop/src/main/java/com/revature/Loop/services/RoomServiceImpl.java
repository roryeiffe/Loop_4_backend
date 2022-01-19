package com.revature.Loop.services;

import com.revature.Loop.entities.Room;
import com.revature.Loop.entities.User;
import com.revature.Loop.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    RoomRepository roomRepository;

    @Override
    public Room addRoom() {
        Room room = new Room();
        roomRepository.save(room);
        return room;
    }

    @Override
    public Room getRoom(Long id) {
        Optional<Room> temp = roomRepository.findById(id);
        if(temp.isEmpty()) {
            return null;
        }
        else {
            return temp.get();
        }
    }

    @Override
    public Room getRoomByPassword(String password) {
        return roomRepository.findRoomByPassword(password);
    }

    @Override
    public Room updateRoom(Long id, Room room) {
        room.setId(id);
        roomRepository.save(room);
        return room;
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
