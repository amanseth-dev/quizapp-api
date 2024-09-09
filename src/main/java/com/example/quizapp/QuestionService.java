package com.example.quizapp;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {
    // method to retrieve all questions
    ResponseEntity<List<Question>> getAllQuestions();

    // method to retrieve questions based on category
    ResponseEntity<List<Question>> getAllQuestionsBasedOnCategory(String category);

    // method to retrieve questions based on difficulty level
    ResponseEntity<List<Question>> getQuestionsBasedOnDifficultyLevel(String difficulty);

    ResponseEntity<String> addQuestion(Question question);
}
