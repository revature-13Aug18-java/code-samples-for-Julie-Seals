package com.revature.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionManager
{
	static SessionFactory fact = null; 
	
	public static void setFactory() 
	{
		Configuration con = new Configuration().configure("hibernate.cnf.xml");
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		fact = con.buildSessionFactory(sr);
		
	}
	
	
	public static Session getSession()
	{
		if(fact == null)
			setFactory();
		if(fact == null)
			return null;
		return fact.openSession();
	}

}
