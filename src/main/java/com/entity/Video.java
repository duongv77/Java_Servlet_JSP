package com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@NamedQueries(
		@NamedQuery(
				name="OderVideoDESC",
				query="SELECT obj FROM Video obj ORDER BY obj.views DESC"
		)
)

@Entity
@Table(name="videos") 
public class Video implements Serializable{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="poster")
	private String poster;
	
	@Column(name="views")
	private Integer views;
	
	@Column(name="description")
	private String description;
	
	@Column(name="active")
	private Integer active;
	
	@Column(name="linkvideo")
	private String linkvideo;
	
	@OneToMany(mappedBy="video", fetch = FetchType.LAZY)
	private List<Share> share;
	
	@OneToMany(mappedBy="video", fetch = FetchType.LAZY)
	private List<Favorite> favorite;
	
	public List<Share> getShare() {
		return share;
	}

	public void setShare(List<Share> share) {
		this.share = share;
	}

	public List<Favorite> getFavorite() {
		return favorite;
	}

	public void setFavorite(List<Favorite> favorite) {
		this.favorite = favorite;
	}

	public Video() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getLinkvideo() {
		return linkvideo;
	}

	public void setLinkvideo(String linkvideo) {
		this.linkvideo = linkvideo;
	}
	
	
}
