package com.quiz.quizProject.Models;

import java.util.List;

import javax.swing.border.TitledBorder;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Quiz {
	
	public List<Question> getQuestion() {
		return question;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	@ManyToMany
	private List<Question> question;

	public void setTitle(String title) {
		this.title = title;
		
	}

	public void setQuestion(List<Question> question) {
		// TODO Auto-generated method stub
		this.question = question;
		
	}
	

}
