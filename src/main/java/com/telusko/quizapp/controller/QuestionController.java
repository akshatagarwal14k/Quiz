package com.telusko.quizapp.controller;

import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping(path="allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

//    Using request param instead of path variable will change the path to http://localhost:8080/question/category/Java?category=Java
//    so category will be needed to be passed as Request parameter

//    @GetMapping(path="/category/{category}")
//    public List<Question> getQuestionsByCategory(@RequestParam String category){
//        return questionService.getQuestionsByCategory(category);
//    }

    @GetMapping(path="category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping(path="add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @DeleteMapping(path="delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }

    @PutMapping(path="update")
    public ResponseEntity<Question> saveOrUpdateQuestion(@RequestBody Question question){
        return questionService.saveOrUpdateQuestion(question);
    }

}
