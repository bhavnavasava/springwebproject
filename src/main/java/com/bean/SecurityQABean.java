package com.bean;

public class SecurityQABean {
	Integer SQuestionId;
	String SQuestion;
	String QAnswer;
	Integer userId;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getSQuestionId() {
		return SQuestionId;
	}
	public void setSQuestionId(Integer sQuestionId) {
		SQuestionId = sQuestionId;
	}
	public String getSQuestion() {
		return SQuestion;
	}
	public void setSQuestion(String sQuestion) {
		SQuestion = sQuestion;
	}
	public String getQAnswer() {
		return QAnswer;
	}
	public void setQAnswer(String qAnswer) {
		QAnswer = qAnswer;
	}
	

}
