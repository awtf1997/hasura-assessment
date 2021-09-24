package com.exercise.hasura.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.hasura.assessment.entity.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

}
