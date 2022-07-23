package com.alkemyDisney.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.alkemyDisney.model.Charact;
import com.alkemyDisney.model.Genre;
import com.alkemyDisney.model.Movie;

@Service
public class MovieDTO {
	
	private int idMovie;
	private String image;
	private String title;
	private Date releaseDate;
	private int rate;
	private Set<CharactDTO> characters = new HashSet<>();
	private Set<Genre> genres = new HashSet<>();
	
	public MovieDTO() {}
	
	public MovieDTO(Movie movie) {
		this.idMovie = movie.getIdMovie();
		this.image = movie.getImage();
		this.title = movie.getTitle();
		this.releaseDate = movie.getReleaseDate();
		this.rate = movie.getRate();
//		this.genres = genres;
		
		for(Charact character : movie.getCharacters()) {
			CharactDTO charactDTO = new CharactDTO();
			charactDTO.setAge(character.getAge());
			charactDTO.setHistory(character.getHistory());
			charactDTO.setIdCharacter(character.getIdCharacter());
			charactDTO.setImage(character.getImage());
			charactDTO.setName(character.getName());
			charactDTO.setWeight(character.getWeight());
			characters.add(charactDTO);
		}
		
		// TODO: arrange this line
		this.genres = null;
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

	public Set<CharactDTO> getCharacters() {
		return characters;
	}

	public void setCharacters(Set<CharactDTO> characters) {
		this.characters = characters;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}
	
}
