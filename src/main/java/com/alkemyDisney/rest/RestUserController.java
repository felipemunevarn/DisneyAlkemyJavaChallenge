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
import org.springframework.web.bind.annotation.RestController;

import com.alkemyDisney.dao.IMovieDao;
import com.alkemyDisney.dao.IRoleDao;
import com.alkemyDisney.dao.IUserDao;
import com.alkemyDisney.model.Charact;
import com.alkemyDisney.model.Movie;
import com.alkemyDisney.model.Role;
import com.alkemyDisney.model.User;

@RestController
@RequestMapping(value = "/users")
public class RestUserController {

	@Autowired
	@Qualifier("user")
	private IUserDao repo;
	
	@Autowired
	IRoleDao roleRepository;
	
	@GetMapping
	public List<User> list(){
		return repo.findAll();
	}

	@PostMapping
	public User insert(@RequestBody User user) {
		return repo.save(user);
	}
	
	@DeleteMapping(value = "/{id_user}")
	public void deleteById(@PathVariable("id_user") Integer id) {
		repo.deleteById(id);
	}
	
	@PutMapping(value = "/{userId}/roles/{roleId}")
	public User associateRolesToUser(
			@PathVariable("roleId") Integer roleId, 
			@PathVariable("userId") Integer userId) {
		Role role = roleRepository.findById(roleId).get();
		User user = repo.findById(userId).get();
		user.associateRole(role);
		return repo.save(user);
	}
	
}
