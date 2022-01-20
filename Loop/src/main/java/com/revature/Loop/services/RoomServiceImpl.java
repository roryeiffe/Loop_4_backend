package com.revature.Loop.services;

import com.revature.Loop.entities.Answer;
import com.revature.Loop.entities.Question;
import com.revature.Loop.entities.Room;
import com.revature.Loop.entities.User;
import com.revature.Loop.repositories.AnswerRepository;
import com.revature.Loop.repositories.QuestionRepository;
import com.revature.Loop.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RoomServiceImpl implements RoomService{

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
    public Room initializeRoom(Long id) {
        Room room = roomRepository.findById(id).get();
        // TODO: make this the number of players in the lobby:
        int numQuestions = 5;
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
