package com.mvc.dao;

public class McqBean {
	private int mcqid;
	private String question;
	private String choicea;
	private String choiceb;
	private String choicec;
	private String choiced;
	private String answer;
	private String hint1;
	private String hint2;
	private String hint3;
	private String feedback;
		
	public int getMcqId() {
	return mcqid;
	}
	public void setMcqId(int mcqid) {
	this.mcqid = mcqid;
	}
	public String getQuestion() {
	return question;
	}
	public void setQuestion(String question) {
	this.question = question;
	}
	public String getChoiceA() {
	return choicea;
	}
	public void setChoiceA(String choicea) {
	this.choicea = choicea;
	}
	public String getChoiceB() {
	return choiceb;
	}
	public void setChoiceB(String choiceb) {
	this.choiceb = choiceb;
	}
	public String getChoiceC() {
	return choicec;
	}
	public void setChoiceC(String choicec) {
	this.choicec = choicec;
	}
	public String getChoiceD() {
	return choiced;
	}
	public void setChoiceD(String choiced) {
	this.choiced = choiced;
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
