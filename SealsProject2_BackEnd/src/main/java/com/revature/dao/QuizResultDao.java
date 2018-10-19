package com.revature.dao;

import java.util.List;

import com.revature.beans.Quiz;
import com.revature.beans.QuizResult;
import com.revature.beans.User;

public interface QuizResultDao 
{
	QuizResult getResultById(long id);
	List<QuizResult> getResultByUser(User id);
	List<QuizResult> getResultByQuiz(Quiz id);
	
	public int createResult(QuizResult qr);
	public void updateResult(QuizResult qr);
	public void deleteResult(QuizResult qr);
}
