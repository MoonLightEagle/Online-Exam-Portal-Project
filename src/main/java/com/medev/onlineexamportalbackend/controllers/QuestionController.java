package com.medev.onlineexamportalbackend.controllers;

import com.medev.onlineexamportalbackend.entity.Question;
import com.medev.onlineexamportalbackend.services.QuestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/exam/{id}")
    public Question postQuestionByExamId(@PathVariable Long id, @RequestBody Question question){
        return questionService.postQuestionByExamId(id,question);
    }
}
