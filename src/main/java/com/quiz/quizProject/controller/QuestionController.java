package com.quiz.quizProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.quizProject.Models.Question;
import com.quiz.quizProject.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions")
	public ResponseEntity< List<Question> > getAllQuestions() {
		return questionService.getAllQuestions();
		
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity< List<Question> > getQuestionByCategory(@PathVariable() String category) {
		return questionService.getQuestionByCategory(category);
		
	}
	
	@PostMapping("addQuestion")
	public ResponseEntity< String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	
	@PostMapping("deleteQuestion")
	public ResponseEntity< String> deleteQuestion(@RequestBody Question question) {
		return questionService.deleteQuestion(question.getId());
	}
}
