package com.revature.Loop.services;

import com.revature.Loop.entities.Player;
import com.revature.Loop.repositories.RoomRepository;
import com.revature.Loop.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    RoomRepository roomRepository;

    @Override
    public void add(Player player) {
        playerRepository.save(player);
    }

    @Override
    public Player getById(Long id) {
        Optional<Player> temp = playerRepository.findById(id);
        if(temp.isEmpty()) {
            return null;
        }
        else {
            return temp.get();
        }
    }

    @Override
    public List<Player> getForRoom(Long id) {
        return roomRepository.getById(id).getPlayers();
    }

    @Override
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Player update(Long id, Player player) {
        player.setId(id);
        playerRepository.save(player);
        return player;
    }

    @Override
    public void reset(Long id, boolean full) {
        Player playerDB = playerRepository.getById(id);
        playerDB.setVote_count(0);
        playerDB.setCurrent_score(0);
        // if full reset, reset the total score as well:
        if(full) playerDB.setTotal_score(0);
        playerRepository.save(playerDB);
    }
}
