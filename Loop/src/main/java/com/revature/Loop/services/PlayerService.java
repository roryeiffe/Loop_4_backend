package com.revature.Loop.services;

import com.revature.Loop.entities.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {
    public void add(Player player);
    public Player getById(Long id);
    public List<Player> getForRoom(Long id);
    public void delete(Long id);
    public Player update(Long id, Player player);
    public void reset(Long id, boolean full);

}
