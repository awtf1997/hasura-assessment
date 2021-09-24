package com.exercise.hasura.assessment.model;

public class ArtistResponse {
	
	private String artistId;

	private String name;
	
	private String comments;

	public ArtistResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArtistResponse(String artistId, String name, String comments) {
		super();
		this.artistId = artistId;
		this.name = name;
		this.comments = comments;
	}

	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
