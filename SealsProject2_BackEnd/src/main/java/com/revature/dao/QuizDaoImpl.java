package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Quiz;
import com.revature.util.HibernateUtil;

public class QuizDaoImpl implements QuizDao {

	@Override
	public List<Quiz> getQuizzesByUserId(int id) {
		Session s = HibernateUtil.getSession();
		String hql = "from Quiz where creator = :idVar";
		Query q = s.createQuery(hql);
		q.setInteger("idVar", id);
		List<Quiz> quizzes = q.list();
		s.close();
		return quizzes;
	}

	@Override
	public Quiz getQuizByQuizId(int id) {
		Session s = HibernateUtil.getSession();
		List<Quiz> quizzes = s.createQuery("from Quiz").list();
		for(Quiz q : quizzes)
		{
			if(q != null && q.getQuizId() == id)
				return q;
		}
		return null;
	}

	@Override
	public List<Quiz> getQuizList() {
		Session s = HibernateUtil.getSession();
		List<Quiz> quizzes = s.createQuery("from Quiz").list();
		s.close();
		return quizzes;
	}

	@Override
	public int createQuiz(Quiz q) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int quizPK = (int) s.save(q);
		tx.commit();
		s.close();
		System.out.println("Quiz Saved as " + quizPK);
		return quizPK;

	}

	@Override
	public void updateQuiz(Quiz q) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(q);
		tx.commit();
		s.close();		
	}

	@Override
	public void deleteQuiz(Quiz q) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(q);
		tx.commit();
		s.close();	
	}
	
	@Override
	public void deleteQuizById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Quiz q = (Quiz) s.get(Quiz.class, id);
		if(q != null) {
			s.delete(q);
		}
		tx.commit();
		s.close();
		
	}

	@Override
	public Quiz getQuizByQuizName(String n) {
		Session s = HibernateUtil.getSession();
		String hql = "from Quiz where quizName = :idStr";
		Query q = s.createQuery(hql);
		q.setString("idStr", n);
		List<Quiz> quizzes = q.list();
		s.close();
		if(quizzes.size() == 0)
			return null;
		return quizzes.get(0);
	}

	@Override
	public List<Quiz> getQuizzesByLockStatus(int lockStatus) {
		Session s = HibernateUtil.getSession();
		List<Quiz> quizzes = s.createQuery("from Quiz").list();
		List<Quiz> quizzesLS = new ArrayList<>();
		for(Quiz q : quizzes)
		{
			if(q != null && q.getLockStatus() == lockStatus) {
				quizzesLS.add(q);
			}
		}
		s.close();
		return quizzesLS;	
	}

	@Override
	public List<Quiz> getLockedQuizzesByUserId(int id) {
		Session s = HibernateUtil.getSession();
		String hql = "from Quiz where creator = :idVar";
		Query q = s.createQuery(hql);
		q.setInteger("idVar", id);
		List<Quiz> quizzes = q.list();
		List<Quiz> quizzesLS = new ArrayList<>();
		for(Quiz quiz : quizzes)
		{
			if(quiz != null && quiz.getLockStatus() == 0) {
				quizzesLS.add(quiz);
			}
				
		}	
		s.close();
		return quizzesLS;
	}

	@Override
	public List<Quiz> getUnlockedQuizzesByUserId(int id) {
		Session s = HibernateUtil.getSession();
		String hql = "from Quiz where creator = :idVar";
		Query q = s.createQuery(hql);
		q.setInteger("idVar", id);
		List<Quiz> quizzes = q.list();
		List<Quiz> quizzesLS = new ArrayList<>();
		for(Quiz quiz : quizzes)
		{
			if(quiz != null && quiz.getLockStatus() == 1) {
				quizzesLS.add(quiz);
			}
				
		}	
		s.close();
		return quizzesLS;
	}
}