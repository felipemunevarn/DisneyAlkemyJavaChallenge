package com.alkemyDisney.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idGenre;
	
	private String image;
	
	private String name;

	@JsonIgnore
	@ManyToMany(mappedBy = "genres")
	Set<Movie> movies= new HashSet<>();

	public Genre() {}

	public Genre(int idGenre, String image, String name, Set<Movie> movies) {
		super();
		this.idGenre = idGenre;
		this.image = image;
		this.name = name;
		this.movies = movies;
	}

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
