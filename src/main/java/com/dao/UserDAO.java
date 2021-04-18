	package com.dao;

import java.util.List;
import java.util.Random;

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
	
	public User store(User entity) {
		this.hSession.beginTransaction();
		Integer id = (Integer) this.hSession.save(entity);
		this.hSession.getTransaction().commit();
		
		entity.setId(id);
		
		return entity;
	}
	
	public void update(User user) {
		try {
			this.hSession.clear();
			this.hSession.beginTransaction();
			this.hSession.update(user);
			this.hSession.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.hSession.getTransaction().rollback();
		}
	}
	
	public List<User> fullUser() {
		String hql = "FROM User"; //Truy vấn hql
		Query query =  this.hSession.createQuery(hql);
		List<User> ListUser = query.getResultList();
		return ListUser;
	}
	
	public User findByID(int id) {
		User entity = this.hSession.get(User.class, id); //truy vấn trả về id cần tìm
		return entity;
	}
	
	public void delete(User entity) {
		this.hSession.clear();
		try {
			this.hSession.beginTransaction();
			this.hSession.delete(entity);
			this.hSession.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
			this.hSession.getTransaction().rollback();
			throw e;
		}
	}
	
	public User kiemTraUser(String email) {
		String hql = "SELECT obj FROM User obj WHERE obj.email = :email";
		Query query = this.hSession.createQuery(hql);
		query.setParameter("email", email);
		try {
			User entity = (User) query.getSingleResult();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String setMK(String email) {
		try {
			Random generator = new Random();
			String password = generator.nextInt(23456)+"";
			User user = this.kiemTraUser(email);
			user.setPassword(password);
			update(this.kiemTraUser(email));
			return password;
		} catch (Exception e) {
			return null;
		}
		
	}
	
}
