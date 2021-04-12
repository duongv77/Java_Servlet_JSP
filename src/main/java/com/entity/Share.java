package com.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="videos") 
public class Share implements Serializable{
	@Id
	@Column(name="id")
	private Integer id;
	
	@OneToOne()
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne()
	@JoinColumn(name="video_id")
	private Video video;
	
	
	@Column(name="sharedate")
	private String sharedate;
	
	public Share() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}


	public String getSharedate() {
		return sharedate;
	}

	public void setSharedate(String sharedate) {
		this.sharedate = sharedate;
	}
	
	
}
