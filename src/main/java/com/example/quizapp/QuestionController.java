package com.example.quizapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("question")
public class QuestionController {
    @GetMapping("allQuestions")
    public String getAllQuestions() {
        // Implement logic to fetch all questions from the database
        return "All questions";
    }
}
