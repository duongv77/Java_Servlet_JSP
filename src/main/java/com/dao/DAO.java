package com.dao;

import org.hibernate.Session;

import com.entity.User;
import com.utils.HibenateUtil;

public class DAO {
	private Session hSession;
	public DAO() {
		hSession = HibenateUtil.getSession();
	}
	
	public User store(User entity) {
		this.hSession.beginTransaction();
		Integer id = (Integer) this.hSession.save(entity);
		this.hSession.getTransaction().commit();
		
		entity.setId(id);
		
		return entity;
	}
}
