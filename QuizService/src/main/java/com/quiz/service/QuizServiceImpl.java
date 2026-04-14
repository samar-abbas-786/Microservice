package com.quiz.service;

import com.quiz.entity.Quiz;
import com.quiz.exception.QuizNotFoundException;
import com.quiz.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;
    private final QuestionClient questionClient;
    public QuizServiceImpl(QuizRepository quizRepository,QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public List<Quiz> getAll() {
        List<Quiz>allQuizzes = quizRepository.findAll();
        allQuizzes.stream().forEach(quiz -> quiz.setQuestions(questionClient.getAllQuestionsOfQuiz(quiz.getId())));
        return allQuizzes;
    }

    @Override
    public Quiz getById(Long id) {
        Quiz quiz=quizRepository.findById(id).orElseThrow(()->new QuizNotFoundException("No Quiz Found"));
        quiz.setQuestions(questionClient.getAllQuestionsOfQuiz(quiz.getId()));
        return quiz;
    }

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }
}
