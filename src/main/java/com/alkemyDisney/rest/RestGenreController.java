package com.alkemyDisney.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemyDisney.dao.IGenreDao;
import com.alkemyDisney.model.Genre;

@RestController
@RequestMapping(value = "/genres")
public class RestGenreController {

	@Autowired
	@Qualifier("genre")
	private IGenreDao repo;
	
//	@GetMapping
//	public List<Genre> list(){		
//		return repo.findAll();
//	}

	@PostMapping
	public void insert(@RequestBody Genre genre) {
		repo.save(genre);
	}
//	
//	@PutMapping
//	public void modify(@RequestBody Charact character) {
//		repo.save(character);
//	}
//	
//	@DeleteMapping(value = "/{id_character}")
//	public void deleteById(@PathVariable("id_character") Integer id) {
//		repo.deleteById(id);
//	}
	
}
