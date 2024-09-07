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
}
