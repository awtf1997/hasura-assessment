package com.exercise.hasura.assessment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.exercise.hasura.assessment.entity.Album;
import com.exercise.hasura.assessment.entity.Artist;
import com.exercise.hasura.assessment.model.AlbumRequest;
import com.exercise.hasura.assessment.model.AlbumResponse;
import com.exercise.hasura.assessment.model.ArtistRequest;
import com.exercise.hasura.assessment.model.ArtistResponse;

public interface AlbumService {

	List<AlbumResponse> getAlbums(String albumToGet);

	List<AlbumResponse> saveAlbums(List<AlbumRequest> albumsToSave);

	List<AlbumResponse> updateAlbums(List<AlbumRequest> albumsToUpdate);

	List<AlbumResponse> deleteAlbums(String albumToDelete);
	
	static List<AlbumResponse> convertAlbumEntityToResponseModel(Album album, String comments) {
		// TODO Auto-generated method stub
		Artist artist = album.getArtist();
		List<AlbumResponse> albumResponse = 
			Arrays.asList(
			new AlbumResponse(
				album.getAlbumId().toString(),
				album.getTitle(), 
				new ArtistResponse(
					artist.getArtistId().toString(),
					artist.getName(),
					""), 
				comments)
			);
		return albumResponse;
	}
	
	static List<AlbumResponse> convertAlbumEntityToResponseModel(List<Album> albumList) {
		// TODO Auto-generated method stub
		List<AlbumResponse> albumResponses = new ArrayList<>();
		if (albumList != null) {
			albumResponses = 
				albumList.stream()
				.filter(e -> e != null)
				.map(e -> {
					Artist artist = e.getArtist();
					AlbumResponse albumResponse = new AlbumResponse(e.getAlbumId().toString(),
					e.getTitle(), new ArtistResponse(artist.getArtistId().toString(), artist.getName(), ""), e.getComments());
					return albumResponse;})
				.collect(Collectors.toList());
			return albumResponses;
		} else {
			albumResponses.add(new AlbumResponse("", "", null, "no items were found"));
			return albumResponses;
		}
	}
	
	static List<Album> convertRequestModelToAlbumEntity(List<AlbumRequest> albumsToSave) {
		// TODO Auto-generated method stub
		List<Album> albums = new ArrayList<>();
		if (albumsToSave != null) {
			albums = 
				albumsToSave.stream()
				.filter(e -> e != null && e.getArtist() != null)
				.map(e -> {
					ArtistRequest artistRequest = e.getArtist();
					Artist artist = new Artist(Long.parseLong(artistRequest.getArtistId()), artistRequest.getName());
					Album album = new Album(Long.parseLong(e.getAlbumId()), e.getTitle(), artist, "");
					return album;
				})
				.collect(Collectors.toList());
			return albums;
		} else {
			return albums;
		}
	}

}
