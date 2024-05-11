package com.quiz.quizProject.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuizAnswer {
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	public QuizAnswer(Integer id, String rightAnswer) {
		super();
		this.id = id;
		this.rightAnswer = rightAnswer;
	}
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("right_answer")
	private String rightAnswer;
}
