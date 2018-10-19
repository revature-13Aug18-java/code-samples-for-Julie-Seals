package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.beans.Quiz;
import com.revature.beans.QuizResult;
import com.revature.beans.User;
import com.revature.service.QuizResultService;
import com.revature.service.QuizService;
import com.revature.service.UserService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class QuizResultController 
{
	@Autowired
	QuizResultService resultService;
	
	@Autowired
	UserService userServe;
	
	@Autowired
	QuizService qServe;
	
	@RequestMapping(value="/submitQuiz", method=RequestMethod.POST)
	public Boolean /* Quiz */ submitQuiz(@RequestBody QuizResult qr)
	{
		return null;
	}
	
	@RequestMapping(value="/getUserResults/{id}", method=RequestMethod.GET)
	public List<QuizResult> getResultsByUser(@RequestParam("id") int id)
	{
		User u = userServe.findUserById(id);
		if(u == null)
			return new ArrayList<QuizResult>();
		
		return resultService.findResultByUser(u);
	}

	@RequestMapping(value="/getResultsByQuiz/{id}", method=RequestMethod.GET)
	public List<QuizResult> getResultsByQuiz(@RequestParam("id") int id)
	{
		Quiz q = qServe.findQuizById(id);
		if(q == null)
			return new ArrayList<QuizResult>();
		
		return resultService.findResultByQuiz(q);
	}
}
