package com.alkemyDisney.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMovie;
	
	private String image;
	
	private String title;
	
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	
	private int rate;
	
	@ManyToMany(mappedBy = "movies")
	List<Charact> characters;
	
	@ManyToMany
    @JoinTable(name = "movie_genre", 
    joinColumns = @JoinColumn(name = "idMovie", referencedColumnName = "idMovie"), 
    inverseJoinColumns = @JoinColumn(name = "idGenre", referencedColumnName = "idGenre"))
	private List<Genre> genres;
	
	public Movie() {
		super();
	}

	public Movie(int idMovie, String image, String title, Date releaseDate, int rate, List<Charact> characters,
			List<Genre> genres) {
		super();
		this.idMovie = idMovie;
		this.image = image;
		this.title = title;
		this.releaseDate = releaseDate;
		this.rate = rate;
		this.characters = characters;
		this.genres = genres;
	}

	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public List<Charact> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Charact> characters) {
		this.characters = characters;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

}
