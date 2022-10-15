package com.revature.Loop.controllers;

import com.revature.Loop.entities.Answer;
import com.revature.Loop.entities.Question;
import com.revature.Loop.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping()
    public void add(@RequestParam(value = "generate", required = false) boolean gen, @RequestBody Question question) {
        if(gen) questionService.generateQuestions();
        else questionService.add(question);
    }

    @GetMapping()
    public List<Question> getAll() {
        return questionService.getAll();
    }
}
