package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.User;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserByUsername(String username) {
		Session s = HibernateUtil.getSession();
		String hql = "from User where username = :un";
		Query q = s.createQuery(hql);
		q.setParameter("un", username);
		List<User> users = q.list();
		User user = users.get(0);
		return user;
	}

	@Override
	public User getUserById(int id) {
		Session s = HibernateUtil.getSession();
		User user = (User) s.get(User.class, id);
		return user;
	}
	
	
	@Override
	public List<User> getUserList() {
		Session s = HibernateUtil.getSession();
		List<User> users = s.createQuery("from User").list();
		s.close();
		return users;
	}

	@Override
	public int createUser(User user) {
		String username = user.getUsername();
		int userPK;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		if(isMatchUsername(username)) {
			userPK = 0;
		} else {
			userPK = (int) s.save(user);
		}
		tx.commit();
		s.close();
		return userPK;
	}

	@Override
	public void updateUser(User user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(user);
		tx.commit();
		s.close();
	}

	@Override
	public void deleteUser(User user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(user);
		tx.commit();
		s.close();
	}
	

	@Override
	public boolean isMatchPassword(String username, String pwd) {
		User u = new User();
		Session s = HibernateUtil.getSession();
		String hql = "From User u WHERE u.username = :un AND u.pwd = :pw";
		Query q = s.createQuery(hql);
		q.setParameter("un", username);
		q.setParameter("pw", pwd);
		List<User> users = q.list();
		for(User uy : users)
			System.out.println(uy);
		
		if(!users.isEmpty()) {
			return true;
		} else {			
		return false;
		}
	}

	@Override
	public boolean isMatchUsername(String username) {
		User u = new User();
		Session s = HibernateUtil.getSession();
		String hql = "From User u WHERE u.username = :un";
		Query q = s.createQuery(hql);
		q.setParameter("un", username);
		List<User> users = q.list();
		
		if(users.isEmpty()){
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void deleteUserById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction(); 
		User user = (User) s.get(User.class, id);
		if(user != null) {
			s.delete(user);
		}		
		tx.commit();
		s.close();
		
	}

}