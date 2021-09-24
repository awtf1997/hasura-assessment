package com.exercise.hasura.assessment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARTIST")
public class Artist {

	@Id
	@Column(name = "ARTIST_ID")
	private Long artistId;
	
	@Column(name = "NAME")
	private String name;

	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Artist(Long artistId, String name) {
		super();
		this.artistId = artistId;
		this.name = name;
	}

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
