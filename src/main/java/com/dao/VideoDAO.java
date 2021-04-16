package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.entity.User;
import com.entity.Video;
import com.utils.HibenateUtil;

public class VideoDAO {
	private Session hSession;
	public VideoDAO() {
		hSession = HibenateUtil.getSession();
	}
	
	public List<Video> paginate(int offset, int limit) {
		String hql = "FROM Video"; //Truy vấn hql
		Query query =  this.hSession.createQuery(hql);
		query.setFirstResult(offset); //lấy từ bản ghi bao nhiêu đến bản ghi bao nhiêu
		query.setMaxResults(offset + limit); //lấy từ bản ghi bao nhiêu đến bản ghi bao nhiêu
		List<Video> ListVideo = query.getResultList();
		return ListVideo;
	}
	
	public Video findByID(int id) {
		Video entity = this.hSession.get(Video.class, id); //truy vấn trả về id cần tìm
		return entity;
	}
	
	public void update(Video video) {
		try {
			this.hSession.clear();
			this.hSession.beginTransaction();
			this.hSession.update(video);
			this.hSession.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.hSession.getTransaction().rollback();
		}
	}
	
	public Video store(Video entity) {
		this.hSession.beginTransaction();
		Integer id = (Integer) this.hSession.save(entity);
		this.hSession.getTransaction().commit();
		
		entity.setId(id);
		
		return entity;
	}
	
	public void delete(Video entity) {
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
}
