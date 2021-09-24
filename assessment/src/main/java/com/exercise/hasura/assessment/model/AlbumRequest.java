package com.exercise.hasura.assessment.model;

public class AlbumRequest {
	
	private String albumId;
	
	private String title;
	
	private ArtistRequest artist;

	public AlbumRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlbumRequest(String albumId, String title, ArtistRequest artist) {
		super();
		this.albumId = albumId;
		this.title = title;
		this.artist = artist;
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

	public ArtistRequest getArtist() {
		return artist;
	}

	public void setArtist(ArtistRequest artistId) {
		this.artist = artistId;
	}
	
}
