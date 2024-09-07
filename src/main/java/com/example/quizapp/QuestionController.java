package com.example.quizapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty");
        }
        return questionService.getAllQuestionsBasedOnCategory(category);
    }
}
