package com.example.quizapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionRepository questionRepository;

    // method to retrieve all questions
    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    // method to retrieve questions based on category
    @Override
    public List<Question> getAllQuestionsBasedOnCategory(String category) {
        // finding questions based on the category ignoring the case-sensitivity
        return questionRepository.findByCategoryIgnoreCase(category);
    }
}
