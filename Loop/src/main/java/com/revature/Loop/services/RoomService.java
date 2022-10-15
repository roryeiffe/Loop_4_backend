package com.revature.Loop.services;

import com.revature.Loop.Exceptions.NotEnoughPlayersException;
import com.revature.Loop.entities.Room;
import org.springframework.stereotype.Service;

@Service
public interface RoomService {
    public Room addRoom();
    public Room addPlayer(Long roomId, Long playerId);
    public Room getRoom(Long id);
    public Room getRoomByPassword(String password);
    public Room updateRoom(Long id, Room room);
    public Room initializeRoom(Long id) throws NotEnoughPlayersException;
    public void deleteRoom(Long id);
}
