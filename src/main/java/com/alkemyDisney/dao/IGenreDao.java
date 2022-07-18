package com.alkemyDisney.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemyDisney.model.Genre;

@Qualifier("genre")
public interface IGenreDao extends JpaRepository<Genre, Integer>  {

//	List<Genre> findMovieByTitle(String title);
	
}