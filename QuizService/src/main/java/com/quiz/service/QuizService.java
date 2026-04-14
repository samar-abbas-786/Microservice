package com.quiz.service;

import com.quiz.entity.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {

    List<Quiz> getAll();
    Quiz getById(Long id);
    Quiz addQuiz(Quiz quiz);

}
