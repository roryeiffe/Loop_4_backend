package com.revature.Loop.services;

import com.revature.Loop.dto.RoomUserIds;
import com.revature.Loop.entities.Room;
import org.springframework.stereotype.Service;

@Service
public interface RoomService {
    public Room addRoom();
    public Room getRoom(Long id);
    public Room getRoomByPassword(String password);
    public Room updateRoom(Long id, Room room);
    public Room addUser(RoomUserIds data);
    public Room initializeRoom(Long id);
    public void deleteRoom(Long id);
}
