package com.alkemyDisney.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alkemyDisney.model.Charact;
import com.alkemyDisney.model.Movie;

@Qualifier("movie")
public interface IMovieDao extends JpaRepository<Movie, Integer>  {

	@Query(value = "SELECT * FROM movie WHERE title = :title", nativeQuery = true)
	List<Movie> findMovieByTitle(@Param("title") String title);

	@Query(value = "SELECT * FROM movie m "
			+ "INNER JOIN movie_genre mg "
			+ "ON m.id_movie = mg.id_movie "
			+ "AND mg.id_genre = :idGenre", nativeQuery = true)
	List<Movie> findMovieByGenres(@Param("idGenre") String idGenre);

}
