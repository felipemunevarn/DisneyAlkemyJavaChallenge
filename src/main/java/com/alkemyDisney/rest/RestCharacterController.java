package com.alkemyDisney.rest;

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
import com.alkemyDisney.dao.IMovieDao;
import com.alkemyDisney.model.Charact;
import com.alkemyDisney.model.Movie;
import com.mysql.cj.util.StringUtils;

@RestController
@RequestMapping(value = "/characters")
public class RestCharacterController {

	@Autowired
	@Qualifier("character")
	private ICharacterDao repo;
	
	@Autowired
	IMovieDao movieRepository;
	
	@GetMapping
	public List<Charact> list(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String age,
			@RequestParam(required = false) String movies) {
		
		if(!StringUtils.isNullOrEmpty(name)) {
            return repo.findCharacterByName(name);
        }
		
		if(!StringUtils.isNullOrEmpty(age)) {
            return repo.findCharacterByAge(Integer.parseInt(age));
        }
		
		if(!StringUtils.isNullOrEmpty(movies)) {
            return repo.findCharacterByMovies(movies);
        }
		
		return repo.findAll();
	}

	@PostMapping
	public Charact insert(@RequestBody Charact character) {
		return repo.save(character);
	}
	
	
	
	@PutMapping
	public Charact modify(@RequestBody Charact character) {
		List<Charact> ch = repo.findCharacterByIdCharacter(character.getIdCharacter());
		character.setMovies(ch.get(0).getMovies());
		return repo.save(character);
	}
	
	@PutMapping(value = "/{characterId}/movies/{movieId}")
	public Charact associateMoviesToCharacter(
			@PathVariable Integer movieId,
			@PathVariable Integer characterId) {
		Movie movie = movieRepository.findById(movieId).get();
		Charact character = repo.findById(characterId).get();
		character.associateMovie(movie);
		return repo.save(character);
	}
	
	@DeleteMapping(value = "/{id_character}")
	public void deleteById(@PathVariable("id_character") Integer id) {
		repo.deleteById(id);
	}
	
}
