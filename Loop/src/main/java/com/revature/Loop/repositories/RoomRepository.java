package com.revature.Loop.repositories;

import com.revature.Loop.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    public Room findRoomByPassword(String password);
}
