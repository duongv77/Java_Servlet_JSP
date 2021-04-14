package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.entity.Favorite;
import com.entity.Video;
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
	
	
}
