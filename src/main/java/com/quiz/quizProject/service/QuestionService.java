package com.quiz.quizProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.quizProject.Dao.QuestionDao;
import com.quiz.quizProject.Models.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
		return new ResponseEntity(questionDao.findAll(),HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_GATEWAY);
	}

	public ResponseEntity<List<Question>>  getQuestionByCategory(String category) {
		try {
			return new ResponseEntity(questionDao.findByCategory(category),HttpStatus.OK);
		}catch (Exception e) {
				e.printStackTrace();
		}
		return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_GATEWAY);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		try {
			questionDao.save(question);
			return new ResponseEntity("Question saved",HttpStatus.CREATED);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<String> deleteQuestion(Integer id) {
		try {
			questionDao.deleteById(id);
			return new ResponseEntity("Question deleted succssfully",HttpStatus.CREATED);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
