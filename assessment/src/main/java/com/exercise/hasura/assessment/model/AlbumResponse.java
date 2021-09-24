package com.exercise.hasura.assessment.model;

public class AlbumResponse {

	private String albumId;

	private String title;

	private ArtistResponse artist;
	
	private String comments;

	public AlbumResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlbumResponse(String title, ArtistResponse artist, String comments) {
		super();
		this.title = title;
		this.artist = artist;
		this.comments = comments;
	}

	public AlbumResponse(String albumId, String title, ArtistResponse artist, String comments) {
		super();
		this.albumId = albumId;
		this.title = title;
		this.artist = artist;
		this.comments = comments;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArtistResponse getArtist() {
		return artist;
	}

	public void setArtist(ArtistResponse artist) {
		this.artist = artist;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
