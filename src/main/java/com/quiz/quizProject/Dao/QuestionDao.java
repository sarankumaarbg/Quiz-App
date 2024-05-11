package com.quiz.quizProject.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.quizProject.Models.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
	
	List<Question> findByCategory(String category);
	
	@Query(value = "SELECT * from question q where q.category=:category order by RANDOM() LIMIT :numQ",nativeQuery = true)
	List<Question> findRandomQuestionBasedOnCategory (String category, int numQ);
}
