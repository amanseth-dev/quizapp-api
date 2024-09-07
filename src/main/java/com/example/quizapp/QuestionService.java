package com.example.quizapp;

import java.util.List;

public interface QuestionService {
    // method to retrieve all questions
    List<Question> getAllQuestions();

    // method to retrieve questions based on category
    List<Question> getAllQuestionsBasedOnCategory(String category);


}
