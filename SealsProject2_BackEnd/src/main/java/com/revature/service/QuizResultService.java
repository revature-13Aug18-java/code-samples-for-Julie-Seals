package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Quiz;
import com.revature.beans.QuizResult;
import com.revature.beans.User;
import com.revature.dao.QuizResultDao;
import com.revature.dao.QuizResultDaoImp;

@Service
public class QuizResultService
{
	QuizResultDao qrd = new QuizResultDaoImp();
	
	public List<QuizResult> findResultByUser(User u)
	{
		return qrd.getResultByUser(u);
	}
	
	public List<QuizResult> findResultByQuiz(Quiz q)
	{
		return qrd.getResultByQuiz(q);
	}
	
	public QuizResult findResultById(long l)
	{
		return qrd.getResultById(l);
	}
	
	public int createResult(QuizResult qr)
	{
		return qrd.createResult(qr);
	}
	
	public void updateResult(QuizResult qr)
	{
		qrd.updateResult(qr);
	}
	
	public void deleteResult(QuizResult qr)
	{
		qrd.deleteResult(qr);
	}
}
