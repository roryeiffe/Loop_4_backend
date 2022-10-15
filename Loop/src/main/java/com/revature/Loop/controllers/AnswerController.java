package com.revature.Loop.controllers;

import com.revature.Loop.entities.Answer;
import com.revature.Loop.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("answers")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping()
    public void add(@RequestParam(value = "generate", required = false) boolean gen, @RequestBody Answer answer) {
        if(gen) answerService.generateAnswers();
        else answerService.add(answer);
    }

    @GetMapping()
    public List<Answer> getAll() {
        return answerService.getAll();
    }
}
