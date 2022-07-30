package com.alkemyDisney.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alkemyDisney.dao.ICharacterDao;
import com.alkemyDisney.dao.IGenreDao;
import com.alkemyDisney.dao.IMovieDao;
import com.alkemyDisney.model.Charact;
import com.alkemyDisney.model.Genre;
import com.alkemyDisney.model.Movie;
import com.alkemyDisney.service.MovieDTO;
import com.mysql.cj.util.StringUtils;

@RestController
@RequestMapping("/movies")
public class RestMovieController {
	
	@Autowired
	@Qualifier("movie")
	private IMovieDao repo;
	
	@Autowired
	ICharacterDao characterRepository;
	
	@Autowired
	IGenreDao genreRepository;
	
	@GetMapping
	public List<MovieDTO> list(
			@RequestParam(required = false) String title,
			@RequestParam(required = false) String genre,
			@RequestParam(required = false) String order) {
		
		if(!StringUtils.isNullOrEmpty(title)) {
            List<Movie> response = repo.findMovieByTitle(title);
            return mapMovies(response);
        }
		
		if(!StringUtils.isNullOrEmpty(genre)) {
			List<Movie> response = repo.findMovieByGenres(genre);
			return mapMovies(response);
        }
		
		List<Movie> response = repo.findAll();
		return mapMovies(response);
	}

	private List<MovieDTO> mapMovies(List<Movie> response) {
		List<MovieDTO> rsp = new ArrayList<>();
		for (Movie movie : response) {
			MovieDTO movieDTO = new MovieDTO(movie);
			rsp.add(movieDTO);
		}
		return rsp;
	}

	@PostMapping
	public void insert(@RequestBody Movie movie) {
		repo.save(movie);
	}
	
	@PutMapping(value = "/{movieId}/characters/{characterId}")
	public Movie associateCharacterToMovies(
			@PathVariable("movieId") Integer movieId,
			@PathVariable("characterId") Integer characterId) {
		Movie movie = repo.findById(movieId).get();
		Charact character = characterRepository.findById(characterId).get();
		movie.associateCharacter(character);
		return repo.save(movie);
	}
	
	@PutMapping(value = "/{movieId}/genres/{genreId}")
	public Movie associateGenresToMovie(
			@PathVariable("movieId") Integer movieId,
			@PathVariable("genreId") Integer genreId) {
		Movie movie = repo.findById(movieId).get();
		Genre genre = genreRepository.findById(genreId).get();
		movie.associateGenre(genre);
		return repo.save(movie);
	}
	
	@PutMapping
	public void modify(@RequestBody Movie movie) {
		repo.save(movie);
	}
	
	@DeleteMapping(value = "/{id_movie}")
	public void deleteById(@PathVariable("id_movie") Integer id) {
		repo.deleteById(id);
	}
	
}