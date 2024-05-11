package com.quiz.quizProject.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.quizProject.Dao.QuestionDao;
import com.quiz.quizProject.Dao.QuizDao;
import com.quiz.quizProject.Models.Question;
import com.quiz.quizProject.Models.QuestionWrapper;
import com.quiz.quizProject.Models.Quiz;
import com.quiz.quizProject.Models.QuizAnswer;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		try {
			List<Question> questions = questionDao.findRandomQuestionBasedOnCategory(category,numQ);
			Quiz quiz = new Quiz();
			quiz.setTitle(title);
			quiz.setQuestion(questions);
			quizDao.save(quiz);
			return new ResponseEntity("Success",HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
		try {
			Optional<Quiz> quiz = quizDao.findById(id);
			List<Question> questions =  quiz.get().getQuestion();
			List<QuestionWrapper> questionWrappers = new ArrayList<>();
			for (Question question : questions) {
				QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(),question.getQuestionTitle(), question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4());
				questionWrappers.add(questionWrapper);
			}
			return new ResponseEntity(questionWrappers,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<QuestionWrapper>> submitQuiz(Integer id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questions =  quiz.get().getQuestion();
		List<QuizAnswer> quizAnswers = new ArrayList<>();
		for (Question question : questions) {
			QuizAnswer quizAnswer = new QuizAnswer(question.getId(),question.getRightAnswer());
			quizAnswers.add(quizAnswer);
		}
		return new ResponseEntity(quizAnswers,HttpStatus.CREATED);
		
	}

	public ResponseEntity<Integer> calculateQuizScore(Integer id, List<QuizAnswer> quizAnswer) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questions =  quiz.get().getQuestion();
		Integer rightAnswerInteger = 0;
		for (Question q : questions) {
			for (QuizAnswer qa : quizAnswer) {
				if (q.getId().equals(qa.getId())) {
					if(q.getRightAnswer().equals(qa.getRightAnswer())) {
						rightAnswerInteger ++;
					}
					break;
				}
			}
		}
		return new ResponseEntity(rightAnswerInteger,HttpStatus.CREATED);
	}

}
