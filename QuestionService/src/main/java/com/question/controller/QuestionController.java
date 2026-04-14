package com.question.controller;

import com.question.entity.Question;
import com.question.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;
    public  QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getAll() {
        return questionService.getAll();
    }
    @PostMapping
    public Question create(@RequestBody Question question) {
        return questionService.create(question);
    }
    @GetMapping("/{questionId}")
    public Question getById(@PathVariable("questionId") Long questionId) {
        return questionService.getById(questionId);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("questionId") Long questionId) {
       questionService.deleteById(questionId);
    }
    @DeleteMapping
    public void deleteAll() {
        questionService.deleteAll();
    }
    @GetMapping("quiz/{quizId}")
    public List<Question>getAllByQuizId(@PathVariable("quizId") Long quizId) {
        return questionService.getAllByQuizId(quizId);
    }
}
