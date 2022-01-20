package com.revature.Loop.controllers;

import com.revature.Loop.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("answers")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping("/generate")
    public void generateAnswers() {
        answerService.generateAnswers();
    }
}
