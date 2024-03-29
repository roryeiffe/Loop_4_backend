package com.revature.Loop.services;

import com.revature.Loop.entities.Answer;
import com.revature.Loop.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public void generateAnswers() {
        for(int i = 0; i < 20; i ++) {
            String category = "food";
            String answer = "answer " + i;
            Answer answerObj = new Answer(category, answer);
            answerRepository.save(answerObj);
        }
    }

    @Override
    public void add(Answer answer){
        answerRepository.save(answer);
    }

    @Override
    public List<Answer> getAll() {
        return answerRepository.findAll();
    }
}
