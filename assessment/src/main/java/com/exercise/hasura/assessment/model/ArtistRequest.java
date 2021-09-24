package com.exercise.hasura.assessment.model;

public class ArtistRequest {
	
	private String artistId;
	
	private String name;
	
	public ArtistRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArtistRequest(String artistId, String name) {
		super();
		this.artistId = artistId;
		this.name = name;
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
}
