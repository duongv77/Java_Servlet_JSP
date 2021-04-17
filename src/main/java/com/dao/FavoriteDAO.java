package com.dao;


import javax.persistence.Query;

import org.hibernate.Session;

import com.entity.Favorite;
import com.utils.HibenateUtil;

public class FavoriteDAO {
	private Session hSession;
	public FavoriteDAO() {
		hSession = HibenateUtil.getSession();
	}
	
	public Favorite findByID(int id) {
		Favorite entity = this.hSession.get(Favorite.class, id);
		return entity;
	}
	
	public Favorite store(Favorite entity) {
		this.hSession.beginTransaction();
		Integer id = (Integer) this.hSession.save(entity);
		this.hSession.getTransaction().commit();
		
		entity.setId(id);
		
		return entity;
	}
	
	public void delete(int userID, int videoID) {
		this.hSession.clear();
		String hql = "SELECT entity FROM Favorite entity WHERE entity.user.id = :user AND entity.video.id = :video";
		Query query =  this.hSession.createQuery(hql);
		query.setParameter("user", userID);
		query.setParameter("video", videoID);
		System.out.println(userID+"hehe"+videoID);
		Favorite favorite =(Favorite) query.getSingleResult();
		System.out.println(favorite.getId());
		try {
			this.hSession.beginTransaction();
			this.hSession.delete(favorite);
			this.hSession.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.hSession.getTransaction().rollback();
			throw e;
		}
	}
	
}
