package com.revature.Loop.repositories;

import com.revature.Loop.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    public Room findRoomByPassword(String password);
}
