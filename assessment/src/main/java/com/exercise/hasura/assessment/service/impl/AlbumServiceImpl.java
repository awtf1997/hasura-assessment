package com.exercise.hasura.assessment.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.hasura.assessment.Constants.ResponseMessageConstants;
import com.exercise.hasura.assessment.entity.Album;
import com.exercise.hasura.assessment.model.AlbumRequest;
import com.exercise.hasura.assessment.model.AlbumResponse;
import com.exercise.hasura.assessment.repository.AlbumRepository;
import com.exercise.hasura.assessment.service.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService {

	private static Logger logger = LoggerFactory.getLogger(AlbumServiceImpl.class);

	@Autowired
	private AlbumRepository albumRepository;

	@Override
	public List<AlbumResponse> getAlbums(String albumToGet) {
		// TODO Auto-generated method stub
		logger.info("inside getAlbums method in service");
		try {
			if (albumToGet != null) {
				logger.info("album id provided: " + albumToGet + ", fetching the unique entry");
				Long albumToGetInLong = Long.parseLong(albumToGet);
				Optional<Album> album = albumRepository.findById(albumToGetInLong);
				if (album.isPresent()) {
					logger.info("corresponding album found in database");
					List<AlbumResponse> responses = AlbumService.convertAlbumEntityToResponseModel(album.get(),
							ResponseMessageConstants.FETCH_SUCCESSFUL);
					return responses;
				} else {
					logger.error("corresponsding album not found in database");
					List<AlbumResponse> responses = Arrays
							.asList(new AlbumResponse(albumToGet, "", null, ResponseMessageConstants.FETCH_UNSUCCESSFUL
									+ ", " + ResponseMessageConstants.NON_EXISITNG_ID_ERROR));
					return responses;
				}
			} else {
				logger.info("album id not provided, fetching all the entries");
				List<Album> albumList = albumRepository.findAll();
				albumList.stream().forEach(e -> e.setComments(ResponseMessageConstants.FETCH_SUCCESSFUL));
				List<AlbumResponse> responses = AlbumService.convertAlbumEntityToResponseModel(albumList);
				return responses;
			}
		} catch (NumberFormatException e) {
			logger.error("exception while converting albumId from string to long");
			List<AlbumResponse> responses = Arrays
					.asList(new AlbumResponse(albumToGet, "", null, ResponseMessageConstants.FETCH_UNSUCCESSFUL + ", "
							+ ResponseMessageConstants.INCORRECT_ID_FORMAT_ERROR));
			return responses;
		} catch (Exception e) {
			logger.error(e.getMessage());
			List<AlbumResponse> responses = Arrays.asList(new AlbumResponse(albumToGet, "", null,
					ResponseMessageConstants.FETCH_UNSUCCESSFUL + ", " + ResponseMessageConstants.UNKNOWN_EXCEPTION));
			return responses;
		}
	}

	@Override
	public List<AlbumResponse> saveAlbums(List<AlbumRequest> albumsToSave) {
		// TODO Auto-generated method stub
		logger.info("inside saveAlbums method in service");
		try {
			List<Album> albumList = AlbumService.convertRequestModelToAlbumEntity(albumsToSave);
			albumList.stream().forEach(e -> {
				Optional<Album> album = albumRepository.findById(e.getAlbumId());
				if (album.isPresent()) {
					e.setComments(ResponseMessageConstants.SAVE_UNSUCCESSFUL + ", "
							+ ResponseMessageConstants.PRE_EXISITNG_ID_ERROR);
				} else {
					albumRepository.save(e);
					e.setComments(ResponseMessageConstants.SAVE_SUCCESSFUL);
				}
			});
			logger.info("saved the albums");
			List<AlbumResponse> responses = AlbumService.convertAlbumEntityToResponseModel(albumList);
			return responses;
		} catch (NumberFormatException e) {
			logger.error("exception while converting albumId/artistId from string to long");
			List<AlbumResponse> responses = Arrays
					.asList(new AlbumResponse("", "", null, ResponseMessageConstants.SAVE_UNSUCCESSFUL + ", "
							+ ResponseMessageConstants.INCORRECT_ID_FORMAT_ERROR));
			return responses;
		} catch (Exception e) {
			logger.error(e.getMessage());
			List<AlbumResponse> responses = Arrays.asList(new AlbumResponse("", "", null,
					ResponseMessageConstants.SAVE_UNSUCCESSFUL + ", " + ResponseMessageConstants.UNKNOWN_EXCEPTION));
			return responses;
		}
	}

	@Override
	public List<AlbumResponse> updateAlbums(List<AlbumRequest> albumsToUpdate) {
		// TODO Auto-generated method stub
		logger.info("inside updateAlbums method in service");
		try {
			List<Album> albumList = AlbumService.convertRequestModelToAlbumEntity(albumsToUpdate);
			albumList.stream().forEach(e -> {
				Optional<Album> album = albumRepository.findById(e.getAlbumId());
				if (!album.isPresent()) {
					e.setComments(ResponseMessageConstants.UPDATE_UNSUCCESSFUL + ", "
							+ ResponseMessageConstants.NON_EXISITNG_ID_ERROR);
				} else {
					albumRepository.save(e);
					e.setComments(ResponseMessageConstants.UPDATE_SUCCESSFUL);
				}
			});
			logger.info("updated the albums");
			List<AlbumResponse> responses = AlbumService.convertAlbumEntityToResponseModel(albumList);
			return responses;
		} catch (NumberFormatException e) {
			logger.error("exception while converting albumId/artistId from string to long");
			List<AlbumResponse> responses = Arrays
					.asList(new AlbumResponse("", "", null, ResponseMessageConstants.UPDATE_UNSUCCESSFUL + ", "
							+ ResponseMessageConstants.INCORRECT_ID_FORMAT_ERROR));
			return responses;
		} catch (Exception e) {
			logger.error(e.getMessage());
			List<AlbumResponse> responses = Arrays.asList(new AlbumResponse("", "", null,
					ResponseMessageConstants.UPDATE_UNSUCCESSFUL + ", " + ResponseMessageConstants.UNKNOWN_EXCEPTION));
			return responses;
		}
	}

	@Override
	public List<AlbumResponse> deleteAlbums(String albumToDelete) {
		// TODO Auto-generated method stub
		logger.info("inside deleteAlbums method in service");
		try {
			if (albumToDelete != null) {
				logger.info("album id provided: " + albumToDelete + ", deleting the unique entry");
				Long albumToDeleteInLong = Long.parseLong(albumToDelete);
				Optional<Album> album = albumRepository.findById(albumToDeleteInLong);
				if (album.isPresent()) {
					albumRepository.deleteById(albumToDeleteInLong);
					Optional<Album> album_ = albumRepository.findById(albumToDeleteInLong);
					if (album_.isPresent()) {
						logger.error("corresponding album still found in database");
						List<AlbumResponse> responses = AlbumService.convertAlbumEntityToResponseModel(album.get(),
								ResponseMessageConstants.DELETE_UNSUCCESSFUL + ", "
										+ ResponseMessageConstants.NON_DELETED_ID_ERROR);
						return responses;
					} else {
						logger.info("corresponding album deleted from database");
						List<AlbumResponse> responses = AlbumService.convertAlbumEntityToResponseModel(album.get(),
								ResponseMessageConstants.DELETE_SUCCESSFUL);
						return responses;
					}
				} else {
					logger.info("corresponding album not found in database");
					List<AlbumResponse> responses = Arrays.asList(
							new AlbumResponse(albumToDelete, "", null, ResponseMessageConstants.DELETE_UNSUCCESSFUL
									+ ", " + ResponseMessageConstants.NON_EXISITNG_ID_ERROR));
					return responses;
				}
			} else {
				logger.info("album id not provided, deleting all the entries");
				List<Album> albumList = albumRepository.findAll();
				albumRepository.deleteAll();
				albumList.stream().forEach(e -> e.setComments(ResponseMessageConstants.DELETE_SUCCESSFUL));
				List<AlbumResponse> responses = AlbumService.convertAlbumEntityToResponseModel(albumList);
				return responses;
			}
		} catch (NumberFormatException e) {
			logger.error("exception while converting albumId from string to long");
			List<AlbumResponse> responses = Arrays
					.asList(new AlbumResponse(albumToDelete, "", null, ResponseMessageConstants.DELETE_UNSUCCESSFUL
							+ ", " + ResponseMessageConstants.INCORRECT_ID_FORMAT_ERROR));
			return responses;
		} catch (Exception e) {
			logger.error(e.getMessage());
			List<AlbumResponse> responses = Arrays.asList(new AlbumResponse(albumToDelete, "", null,
					ResponseMessageConstants.DELETE_UNSUCCESSFUL + ", " + ResponseMessageConstants.UNKNOWN_EXCEPTION));
			return responses;
		}
	}

}
