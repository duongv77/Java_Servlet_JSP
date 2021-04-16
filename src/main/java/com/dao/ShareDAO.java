package com.dao;

import org.hibernate.Session;

import com.entity.Share;
import com.utils.HibenateUtil;

public class ShareDAO {
		private Session hSession;
		public  ShareDAO() {
			hSession = HibenateUtil.getSession();
		}
		
		public Share store(Share entity) {
			
			this.hSession.beginTransaction();
			Integer id =(Integer) this.hSession.save(entity);
			this.hSession.getTransaction().commit();
			
			entity.setId(id);
			
			return entity;
		}
		
}
