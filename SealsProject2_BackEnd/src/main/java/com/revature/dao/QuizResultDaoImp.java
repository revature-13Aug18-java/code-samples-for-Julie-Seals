package com.revature.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Quiz;
import com.revature.beans.QuizResult;
import com.revature.beans.User;
import com.revature.util.HibernateUtil;

public class QuizResultDaoImp implements QuizResultDao 
{

	@Override
	public QuizResult getResultById(long id) 
	{
		Session s = HibernateUtil.getSession();
		return (QuizResult) s.get(QuizResult.class, id);
	}

	@Override
	public List<QuizResult> getResultByUser(User id)
	{
		Session s = HibernateUtil.getSession();
		String hql = "from QuizResult where taker = :id";
		Query q = s.createQuery(hql);
		q.setParameter("id", id);
		
		s.close();
		List<QuizResult> qrs = q.list();
		
		
		return qrs;
	}

	@Override
	public List<QuizResult> getResultByQuiz(Quiz id)
	{
		Session s = HibernateUtil.getSession();
		String hql = "from QuizResult where quiz = :id";
		Query q = s.createQuery(hql);
		q.setParameter("id", id);
		List<QuizResult> qrs = q.list();
		
		s.close();
		return qrs;

	}

	@Override
	public int createResult(QuizResult qr) 
	{
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		int ret = (int) s.save(qr);
		t.commit();
		s.close();
		return ret;
	}

	@Override
	public void updateResult(QuizResult qr) 
	{
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(qr);
		tx.commit();
		s.close();
	}

	@Override
	public void deleteResult(QuizResult qr) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(qr);
		tx.commit();
		s.close();
	}

}
