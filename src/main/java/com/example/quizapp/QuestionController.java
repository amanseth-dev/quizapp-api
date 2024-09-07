package com.example.quizapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("allQuestions")
    public List<Question> getAllQuestions() {
        // Implement logic to fetch all questions from the database
        return questionService.getAllQuestions();
    }

    // method to retrieve questions based on the category
    @GetMapping("/category/{category}")
    public List<Question> getAllQuestionsBasedOnCategory(@PathVariable String category) {
        // Implement logic to fetch questions based on the category from the database
        return questionService.getAllQuestionsBasedOnCategory(category);
    }
}
