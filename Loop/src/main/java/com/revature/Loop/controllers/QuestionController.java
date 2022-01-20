package com.revature.Loop.controllers;

import com.revature.Loop.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/generate")
    public void generateQuestions() {
        questionService.generateQuestions();
    }
}
