package com.alkemyDisney.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemyDisney.model.Movie;

@Qualifier("movie")
public interface IMovieDao extends JpaRepository<Movie, Integer>  {

	List<Movie> findMovieByTitle(String title);

}
