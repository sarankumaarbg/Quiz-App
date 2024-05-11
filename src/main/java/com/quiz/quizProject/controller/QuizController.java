package com.quiz.quizProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.quizProject.Models.QuestionWrapper;
import com.quiz.quizProject.Models.QuizAnswer;
import com.quiz.quizProject.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@PostMapping("createQuiz")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
		return quizService.createQuiz(category,numQ,title);
	}
	
	@GetMapping("getQuiz/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable() Integer id){
		return quizService.getQuiz(id);
	}
	
	@PostMapping("getRightAnswer/{id}")
	public ResponseEntity<List<QuestionWrapper>> submitQuiz(@PathVariable() Integer id){
		return quizService.submitQuiz(id);
	}
	
	@PostMapping("getQuizScore/{id}")
	public ResponseEntity<Integer> calculateQuizScore(@PathVariable() Integer id, @RequestBody() List<QuizAnswer> quizAnswer){
		return quizService.calculateQuizScore(id,quizAnswer);
	}

}
