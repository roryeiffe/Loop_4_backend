package com.revature.Loop.services;

import com.revature.Loop.entities.Answer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerService {
    public void generateAnswers();

    public void add(Answer answer);

    public List<Answer> getAll();
}
