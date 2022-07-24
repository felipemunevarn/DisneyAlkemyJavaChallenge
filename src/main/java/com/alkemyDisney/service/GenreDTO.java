package com.alkemyDisney.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.alkemyDisney.model.Movie;

@Service
public class GenreDTO {
	private int idGenre;
	private String image;
	private String name;
	private Set<Movie> movies= new HashSet<>();
	
	public GenreDTO() {}

	public int getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	
}
