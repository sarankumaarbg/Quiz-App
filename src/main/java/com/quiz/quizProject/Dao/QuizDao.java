package com.quiz.quizProject.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.quizProject.Models.Question;
import com.quiz.quizProject.Models.Quiz;

@Repository
public interface QuizDao  extends JpaRepository<Quiz, Integer>{

}
