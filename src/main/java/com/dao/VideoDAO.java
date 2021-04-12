package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.entity.User;
import com.entity.Video;
import com.utils.Hibenate;

public class VideoDAO {
	private Session hSession;
	public VideoDAO() {
		hSession = Hibenate.getSession();
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
}
