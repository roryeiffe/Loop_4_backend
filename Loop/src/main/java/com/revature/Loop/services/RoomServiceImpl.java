package com.revature.Loop.services;

import com.revature.Loop.dto.RoomUserIds;
import com.revature.Loop.entities.Answer;
import com.revature.Loop.entities.Question;
import com.revature.Loop.entities.Room;
import com.revature.Loop.entities.User;
import com.revature.Loop.repositories.AnswerRepository;
import com.revature.Loop.repositories.QuestionRepository;
import com.revature.Loop.repositories.RoomRepository;
import com.revature.Loop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    UserRepository userRepository;

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
    public Room addUser(RoomUserIds data) {
        Room room = roomRepository.findById(data.getRoomId()).get();
        User user = userRepository.findById(data.getUserId()).get();
        List<User> users = room.getPlayers();
        // make sure this name is unique:
        boolean found = true;
        for(User user_: users) {
            if (user_.getName().equals(user.getName())) found = true;
        }
        if(!found) users.add(user);
        room.setPlayers(users);
        roomRepository.save(room);
        return room;
    }

    @Override
    public Room initializeRoom(Long id) {
        Room room = roomRepository.findById(id).get();
        // TODO: make this the number of players in the lobby:
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
