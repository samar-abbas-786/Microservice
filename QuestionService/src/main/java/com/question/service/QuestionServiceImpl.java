package com.question.service;

import com.question.entity.Question;
import com.question.repository.QuestionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question getById(Long id) {
        return questionRepository.findById(id).orElseThrow(()->new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        questionRepository.deleteAll();
    }

    @Override
    public List<Question> getAllByQuizId(Long quizId) {
        return questionRepository.findAllByQuizId(quizId);
    }
}
