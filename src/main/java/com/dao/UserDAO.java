package com.dao;

import javax.persistence.Query;

import org.hibernate.Session;

import com.entity.User;
import com.utils.HibenateUtil;

public class UserDAO {
	private Session hSession;
	public UserDAO() {
		hSession = HibenateUtil.getSession();
	}
	
	public User login(String email, String password) {
		String hql = "SELECT entity FROM User entity"
					+ " WHERE entity.email = :email AND entity.password = :password" ;
		Query query =  this.hSession.createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		try {
			User entity = (User) query.getSingleResult();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
