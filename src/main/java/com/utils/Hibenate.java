package com.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibenate {
	private static  SessionFactory factory;
	private static  Session session;
	public static SessionFactory getSessionFactory() {
		if(factory == null || !factory.isOpen()) {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml"); // đọc file hibernate.cfg.xml
			
			factory = config.buildSessionFactory(); // tạo ra buid factory
		}
		return factory;
	}

	public static Session getSession() {
		if(session == null || !session.isOpen()) {
			session = getSessionFactory().openSession();
		}
		return session;
	}
}
