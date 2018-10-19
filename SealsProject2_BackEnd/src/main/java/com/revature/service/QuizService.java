package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Quiz;
import com.revature.dao.QuizDao;
import com.revature.dao.QuizDaoImpl;

@Service
public class QuizService 
{
	private QuizDao qd = new QuizDaoImpl();

	public List<Quiz> findAllQuests() 
	{
		return qd.getQuizList();
	}

	public Quiz findQuizById(int id) 
	{
		return qd.getQuizByQuizId(id);
	}
	
	public Quiz findQuizByQuizName(String n)
	{
		return qd.getQuizByQuizName(n);
	}
	
	public Quiz addQuest(Quiz newQuest)
	{
		int quizId = qd.createQuiz(newQuest);
		return qd.getQuizByQuizId(quizId);
	}
	
	public Quiz updateQuest(Quiz quest) 
	{
		qd.updateQuiz(quest);
		return quest;
	}

	public void deleteQuiz(Quiz quest) 
	{
		qd.deleteQuiz(quest);
	}
	
	public void deleteQuizById(int id) 
	{
		qd.deleteQuizById(id);
	}
	
	public List<Quiz> findAllQuizzesByCreatorId(int id)
	{
		return qd.getQuizzesByUserId(id);
	}
	
	public Quiz updateLockStatus(int quizId, int lockStatus) 
	{
		Quiz quiz = qd.getQuizByQuizId(quizId);
		quiz.setLockStatus(lockStatus);
		qd.updateQuiz(quiz);
		return quiz;
	}
	
	public List<Quiz> findAllQuizzesByLockStatus(int lockStatus)
	{
		return qd.getQuizzesByLockStatus(lockStatus);
	}
		
	public List<Quiz> findUnlockedQuizByUserId(int id) 
	{
		return qd.getUnlockedQuizzesByUserId(id);	
	}
	
	public List<Quiz> findLockedQuizByUserId(int id) 
	{
		return qd.getLockedQuizzesByUserId(id);
	}
	
}
