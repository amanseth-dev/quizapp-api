package com.example.quizapp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // finding question by category by ignoring case-sensitivity
    List<Question> findByCategoryIgnoreCase(String category);

    // finding question by difficulty level by ignoring case-sensitivity
    List<Question> findByDifficultyLevelIgnoreCase(String difficultyLevel);
}
