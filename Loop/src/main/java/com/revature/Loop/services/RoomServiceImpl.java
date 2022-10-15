package com.revature.Loop.services;

import com.revature.Loop.Exceptions.NotEnoughPlayersException;
import com.revature.Loop.entities.Answer;
import com.revature.Loop.entities.Question;
import com.revature.Loop.entities.Room;
import com.revature.Loop.entities.Player;
import com.revature.Loop.repositories.AnswerRepository;
import com.revature.Loop.repositories.QuestionRepository;
import com.revature.Loop.repositories.RoomRepository;
import com.revature.Loop.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public Room addRoom() {
        Room room = new Room();
        roomRepository.save(room);
        return room;
    }

    public Room addPlayer(Long roomId, Long playerId) {
        Room room = roomRepository.findById(roomId).get();
        Player player = playerRepository.findById(playerId).get();
        List<Player> players = room.getPlayers();
        // make sure this name is unique:
        boolean found = false;
        for(Player player_ : players) {
            if (player_.getName().equals(player.getName())) found = true;
        }
        if(!found) players.add(player);
        room.setPlayers(players);
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
    public Room initializeRoom(Long id) throws NotEnoughPlayersException{
        Room room = roomRepository.findById(id).get();
        if(room.getPlayers().size() < 3) {
            throw new NotEnoughPlayersException();
        }
        int numQuestions = room.getPlayers().size();
        String category = room.getCategory();
        // generate the random questions:
        List<Question> questions = questionRepository.getRandomQuestions(category, numQuestions);
        room.setQuestions(questions);
        // generate the random answer:
        List<Answer> answers = answerRepository.getRandomAnswers(category, numQuestions);
        room.setAnswers(answers);
        // grab random answer from answers, this will be the "right" answer
        Random generator = new Random();
        room.setAnswer(answers.get(generator.nextInt(answers.size())).getAnswer());
        roomRepository.save(room);
        return room;
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
