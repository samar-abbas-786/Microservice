package com.question.service;

import com.question.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    Question create(Question question);
    Question getById(Long id);
    List<Question> getAll();
    void deleteById(Long id);
    void deleteAll();
    List<Question>getAllByQuizId(Long quizId);

}
