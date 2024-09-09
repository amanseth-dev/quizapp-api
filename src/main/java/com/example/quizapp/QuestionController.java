package com.example.quizapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        // logic to fetch all questions from the database
        return questionService.getAllQuestions();
    }

    // method to retrieve questions based on the category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getAllQuestionsBasedOnCategory(@PathVariable String category) {
        // logic to fetch questions based on the category from the database
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty");
        }
        return questionService.getAllQuestionsBasedOnCategory(category);
    }

    // method to retrieve questions based on difficulty level
    @GetMapping("/difficultyLevel/{difficulty}")
    public ResponseEntity<List<Question>> getQuestionsBasedOnDifficulty(@PathVariable String difficulty) {
        // logic to fetch questions based on the difficulty level from the database
        if (difficulty == null || difficulty.trim().isEmpty()) {
            throw new IllegalArgumentException("Difficulty cannot not be null");
        }
        return questionService.getQuestionsBasedOnDifficultyLevel(difficulty);
    }

    // method to add questions
    @PostMapping("/addQuestions")
    public ResponseEntity<String> addQuestions(@RequestBody Question question){
        // logic to add a new question to the database
        return questionService.addQuestion(question);
    }

    // method to update questions
    @PutMapping("/updateQuestions/{id}")
    public ResponseEntity<String> updateQuestions(@RequestBody Question question, @PathVariable Integer id){
        // logic to update a question in the database
        return questionService.updateQuestion(question, id);
    }
}
