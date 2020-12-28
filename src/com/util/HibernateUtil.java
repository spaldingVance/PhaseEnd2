package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.User;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration().addAnnotatedClass(User.class).configure().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	

}
