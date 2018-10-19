package com.revature.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Question;
import com.revature.beans.Quiz;
import com.revature.util.HibernateUtil;

public class QuestionDaoImpl implements QuestionDao {

	@Override
	public List<Question> getQuestionList() {
		Session s = HibernateUtil.getSession();
		List<Question> questions = s.createQuery("from Question").list();
		s.close();
		return questions;
	}

	@Override
	public int createQuestion(Question q) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int questionPK = (int) s.save(q);
		tx.commit();
		s.close();
		return questionPK;

	}

	@Override
	public void updateQuestion(Question q) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(q);
		tx.commit();
		s.close();		
	}

	@Override
	public void deleteQuestion(Question q) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(q);
		tx.commit();
		s.close();
		
	}

	@Override
	public List<Question> getQuestionByCat(int cat) {
		Session s = HibernateUtil.getSession();
		String hql = "from Question where questCat = :catVar";
		Query q = s.createQuery(hql);
		q.setInteger("catVar", cat);
		List<Question> questions = q.list();
		s.close();
		return questions;
	}

	@Override
	public Question getQuestionById(int id) {
		Session s = HibernateUtil.getSession();
		Question question = (Question) s.get(Question.class, id);
		return question;
	}

	@Override
	public void deleteQuestionById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Question q = (Question) s.get(Question.class, id);
		if(q != null) {
			s.delete(q);
		}
		tx.commit();
		s.close();
		
	}
}

