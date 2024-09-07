package com.example.quizapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("allQuestions")
    public List<Question> getAllQuestions() {
        // Implement logic to fetch all questions from the database
        return questionService.getAllQuestions();
    }
}
