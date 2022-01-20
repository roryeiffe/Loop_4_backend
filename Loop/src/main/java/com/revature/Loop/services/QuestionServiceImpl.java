package com.revature.Loop.services;

import com.revature.Loop.entities.Question;
import com.revature.Loop.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    QuestionRepository questionRepository;


    @Override
    public void generateQuestions() {
        for(int i = 0; i < 20; i ++) {
            String category = "food";
            String question = "question " + i;
            Question questionObj = new Question(category, question);
            questionRepository.save(questionObj);
        }
    }
}
