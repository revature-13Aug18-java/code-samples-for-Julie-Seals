package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Question;
import com.revature.beans.Quiz;
import com.revature.service.QuestionService;
import com.revature.service.QuizService;
import com.revature.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QuizSessionController 
{
	@Autowired
	QuizService qServe;
	
	@Autowired 
	QuestionService questions;
	
	@Autowired
	UserService userServe;
	
	
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	@RequestMapping(value="/QuizSession/{quizId}", method=RequestMethod.GET)
	public List<Question> getQuestions(@PathVariable("quizId") int qId)
	{
		System.out.println("QuizId Detected: " + qId);
		Quiz q = qServe.findQuizById(qId);
		if(q == null)
			return null;
		
		//QuestionDao qe = new QuestionDaoImpl();
		System.out.println("Quiz: " + q);
		
		String[] questionList = q.getQuestions().split(",");
		List<Question> ret = new ArrayList<>();
		for(String question : questionList)
		{
			question = question.trim();
			try
			{
				int questionId = Integer.parseInt(question);
				Question quest = questions.findQuestById(questionId);
				if(quest != null)
					ret.add(quest);
			}
			catch(NumberFormatException e)
			{
				
			}
		}
		System.out.println("Question List: " + ret);
		
		return ret;
		
	}
	
	@RequestMapping(value="/createQuiz", method=RequestMethod.POST)
	public boolean createQuiz(@RequestBody Quiz q)
	{
		System.out.println("Quiz Inserted: " + q);
		return qServe.addQuest(q) != null;
	}
	
//	@RequestMapping(value="/takeQuiz", method=RequestMethod.POST)
//	public List<Question> takeQuiz(HttpServletRequest req, HttpServletResponse res)
//	{
//		String userStr = req.getParameter("userId");
//		String quizStr = req.getParameter("quizId");
//		
//		//Integer qId = 
//		
//		//return userStr != null && quizStr != null;
//	}
	
	
	@RequestMapping(value="/quizExists", method=RequestMethod.POST)
	public boolean doesQuizExist(@RequestBody String qName)
	{
		System.out.println(qName);
		return qServe.findQuizByQuizName(qName) != null;
	}
	
	
	@RequestMapping(value="/addQuestion", method=RequestMethod.POST)
	public int addQuestion(@RequestBody Question q)
	{
		System.out.println("QuestionAdded: " + q);
		Question quest = questions.addQuest(q);
		return quest.getId();
	}
	
	@RequestMapping(value="/updateQuizStatus", method=RequestMethod.POST)
	public Quiz updateQuizStatus(@RequestBody Quiz q) 
	{
		Quiz quiz= qServe.updateLockStatus(q.getQuizId(), q.getLockStatus());
		return quiz;
	}
	
	@RequestMapping(value="/quizList", method=RequestMethod.GET)
	public List<Quiz> getQuizzes()
	{
		return qServe.findAllQuests();
	}
	
	@RequestMapping(value="/users/quizzes/{userId}", method=RequestMethod.GET)
	public List<Quiz> getQuizzesByCreator(@PathVariable("userId") int id)
	{
		return qServe.findAllQuizzesByCreatorId(id);
	}
	
	@RequestMapping(value="/quizzes/lockstatus/{lockStatus}", method=RequestMethod.GET)
	public List<Quiz> getQuizzesByLockStatus(@PathVariable("lockStatus") int lockStatus)
	{
		return qServe.findAllQuizzesByLockStatus(lockStatus);
	}
	
	@RequestMapping(value="/users/quizzes/{userId}/{lockStatus}", method=RequestMethod.GET)
	public List<Quiz> getQuizzesByCreatorIdAndLockStatus(@PathVariable("userId") int id, @PathVariable("lockStatus") int lockStatus)
	{
		if(lockStatus == 0) {
			return qServe.findLockedQuizByUserId(id);
		}
		return qServe.findUnlockedQuizByUserId(id);
	}
}
