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

import com.alkemyDisney.dao.IMovieDao;
import com.alkemyDisney.model.Movie;
import com.mysql.cj.util.StringUtils;

@RestController
@RequestMapping("/movies")
public class RestMovieController {
	
	@Autowired
	@Qualifier("movie")
	private IMovieDao repo;
	
	@GetMapping
	public List<Movie> list(
			@RequestParam(required = false) String title,
			@RequestParam(required = false) String genre,
			@RequestParam(required = false) String order) {
		
		if(!StringUtils.isNullOrEmpty(title)) {
            return repo.findMovieByTitle(title);
        }
		
//		if(!StringUtils.isNullOrEmpty(age)) {
//            return repo.findCharacterByAge(Integer.parseInt(age));
//        }
//		
//		if(idMovie != null) {
//            return repo.findCharacterByIdMovie(idMovie);
//        }
//		
		return repo.findAll();
	}

	@PostMapping
	public void insert(@RequestBody Movie movie) {
		repo.save(movie);
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