package com.example.quizapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionRepository questionRepository;

    // method to retrieve all questions
    @Override
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    // method to retrieve questions based on category
    @Override
    public ResponseEntity<List<Question>> getAllQuestionsBasedOnCategory(String category) {
        // finding questions based on the category ignoring the case-sensitivity
        try {
            return new ResponseEntity<>(questionRepository.findByCategoryIgnoreCase(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    // method to retrieve questions based on difficulty level
    @Override
    public ResponseEntity<List<Question>> getQuestionsBasedOnDifficultyLevel(String difficulty) {
        try {
            return new ResponseEntity<>(questionRepository.findByDifficultyLevelIgnoreCase(difficulty), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    // method to add a new question
    @Override
    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionRepository.save(question);
            return new ResponseEntity<>("Question Successfully add..😎", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Question not added..", HttpStatus.BAD_REQUEST);
    }


    @Override
    public ResponseEntity<String> updateQuestion(Question question, Integer id) {
        try {
            Question existingQuestion = questionRepository.findById(id).orElse(null);
            if(existingQuestion != null) {
                existingQuestion.setQuestionTitle(question.getQuestionTitle());
                existingQuestion.setOption1(question.getOption1());
                existingQuestion.setOption2(question.getOption2());
                existingQuestion.setOption3(question.getOption3());
                existingQuestion.setOption4(question.getOption4());
                existingQuestion.setCorrectAnswer(question.getCorrectAnswer());
                existingQuestion.setCategory(question.getCategory());
                existingQuestion.setDifficultyLevel(question.getDifficultyLevel());
                questionRepository.save(existingQuestion);
                return new ResponseEntity<>("Question updated successfully..", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Question not found..", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Question not updated..", HttpStatus.BAD_REQUEST);
    }
}
