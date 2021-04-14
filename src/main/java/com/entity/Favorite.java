package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@NamedQueries(
		@NamedQuery(
				name = "VideoLike",
				query = "SELECT entity.video FROM Favorite entity WHERE entity.user.id=:userID"
		)
)
@Entity
@Table(name="Favorite") 
public class Favorite {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne()
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne()
	@JoinColumn(name="video_id")
	private Video video;
	
	@Column(name="likedate")
	private String likedate;

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

	public String getLikedate() {
		return likedate;
	}

	public void setLikedate(String likedate) {
		this.likedate = likedate;
	}
	
}
