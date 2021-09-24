package com.exercise.hasura.assessment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ALBUM")
public class Album {

	@Id
	@Column(name = "ALBUM_ID")
	private Long albumId;
	
	@Column(name = "TITLE")
	private String title;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTIST_ID")
	private Artist artist;
	
	@Transient
	private String comments;

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Album(Long albumId, String title, Artist artist, String comments) {
		super();
		this.albumId = albumId;
		this.title = title;
		this.artist = artist;
		this.comments = comments;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
