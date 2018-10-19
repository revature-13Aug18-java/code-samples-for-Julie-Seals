package com.revature.dao;

import java.util.List;

import com.revature.beans.Question;

public interface QuestionDao
{
	public List<Question> getQuestionList();
	public List<Question> getQuestionByCat(int cat);
	public Question getQuestionById(int id);
	public int createQuestion(Question q);
	public void updateQuestion(Question q);
	public void deleteQuestion(Question q);
	public void deleteQuestionById(int id);
}
