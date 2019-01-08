package com.mvc.dao;

public class NumBean {
	private int numid;
	private String question;
	private String answer;
	private String hint1;
	private String hint2;
	private String hint3;
	private String feedback;
		
	public int getNumId() {
	return numid;
	}
	public void setNumId(int numid) {
	this.numid = numid;
	}
	public String getQuestion() {
	return question;
	}
	public void setQuestion(String question) {
	this.question = question;
	}
	public String getAnswer() {
	return answer;
	}
	public void setAnswer(String answer) {
	this.answer = answer;
	}
	public String getHint1() {
	return hint1;
	}
	public void setHint1(String hint1) {
	this.hint1 = hint1;
	}
	public String getHint2() {
	return hint2;
	}
	public void setHint2(String hint2) {
	this.hint2 = hint2;
	}
	public String getHint3() {
	return hint3;
	}
	public void setHint3(String hint3) {
	this.hint3 = hint3;
	}
	public String getFeedback() {
	return feedback;
	}
	public void setFeedback(String feedback) {
	this.feedback = feedback;
	}
}
