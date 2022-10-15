package com.revature.Loop.services;

import com.revature.Loop.entities.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    public void generateQuestions();

    public void add(Question question);

    public List<Question> getAll();
}
