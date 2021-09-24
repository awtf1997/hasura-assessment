package com.exercise.hasura.assessment.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.hasura.assessment.model.AlbumRequest;
import com.exercise.hasura.assessment.model.AlbumResponse;
import com.exercise.hasura.assessment.service.AlbumService;

@RestController
@RequestMapping(path = "/api/v1")
public class Controller {

	private static Logger logger = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private AlbumService albumService;

	@GetMapping(path = "/get/albums/{albumId}")
	public ResponseEntity<List<AlbumResponse>> getAlbums(@RequestParam(name = "albumId", required = false) String albumToGet) {
		logger.info("inside getAlbums method in controller");
		try {
			List<AlbumResponse> responses = albumService.getAlbums(albumToGet);
			ResponseEntity<List<AlbumResponse>> responseEntity = ResponseEntity.status(HttpStatus.OK).body(responses);
			return responseEntity;
		} catch (Exception e) {
			logger.info("encountered exception at saveAlbums method in the controller class");
			List<AlbumResponse> response = Arrays.asList(new AlbumResponse("", "", null, e.getMessage()));
			ResponseEntity<List<AlbumResponse>> responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(response);
			return responseEntity;
		}
	}

	@PostMapping(path = "/save")
	public ResponseEntity<List<AlbumResponse>> saveAlbums(@RequestBody List<AlbumRequest> albumsToSave) {
		logger.info("inside saveAlbums method in controller");
		try {
			List<AlbumResponse> responses = albumService.saveAlbums(albumsToSave);
			ResponseEntity<List<AlbumResponse>> responseEntity = ResponseEntity.status(HttpStatus.OK).body(responses);
			return responseEntity;
		} catch (Exception e) {
			logger.info("encountered exception at saveAlbums method in the controller class");
			List<AlbumResponse> response = Arrays.asList(new AlbumResponse("", "", null, e.getMessage()));
			ResponseEntity<List<AlbumResponse>> responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(response);
			return responseEntity;
		}
	}

	@PutMapping(path = "/update/albums")
	public ResponseEntity<List<AlbumResponse>> updateAlbums(@RequestBody List<AlbumRequest> albumsToUpdate) {
		logger.info("inside updateAlbums method in controller");
		try {
			List<AlbumResponse> responses = albumService.updateAlbums(albumsToUpdate);
			ResponseEntity<List<AlbumResponse>> responseEntity = ResponseEntity.status(HttpStatus.OK).body(responses);
			return responseEntity;
		} catch (Exception e) {
			logger.info("encountered exception at updateAlbums method in the controller class");
			List<AlbumResponse> response = Arrays.asList(new AlbumResponse("", "", null, e.getMessage()));
			ResponseEntity<List<AlbumResponse>> responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(response);
			return responseEntity;
		}
	}

	@DeleteMapping(path = "/delete/albums/{albumId}")
	public ResponseEntity<List<AlbumResponse>> deleteAlbums(@RequestParam(name = "albumId", required = false) String albumToDelete) {
		logger.info("inside deleteAlbum method in controller");
		try {
			List<AlbumResponse> responses = albumService.deleteAlbums(albumToDelete);
			ResponseEntity<List<AlbumResponse>> responseEntity = ResponseEntity.status(HttpStatus.OK).body(responses);
			return responseEntity;
		} catch (Exception e) {
			logger.info("encountered exception at updateAlbums method in the controller class");
			List<AlbumResponse> response = Arrays.asList(new AlbumResponse("", "", null, e.getMessage()));
			ResponseEntity<List<AlbumResponse>> responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(response);
			return responseEntity;
		}
	}

}
