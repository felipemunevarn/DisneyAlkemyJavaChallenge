package com.alkemyDisney.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemyDisney.DisneyApplication;
import com.alkemyDisney.dao.IMovieDao;
import com.alkemyDisney.dao.IRoleDao;
import com.alkemyDisney.dao.IUserDao;
import com.alkemyDisney.model.Charact;
import com.alkemyDisney.model.Movie;
import com.alkemyDisney.model.Role;
import com.alkemyDisney.model.User;

@RestController
@RequestMapping(value = "/users")
public class RestUserController implements UserDetailsService {

	private static Logger log = LoggerFactory.getLogger(DisneyApplication.class);
	
	@Autowired
	@Qualifier("user")
	private IUserDao repo;
	
	@Autowired
	IRoleDao roleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findUserByUserName(username);
		if (user == null) {
			log.error("User not found in the database");
			throw new UsernameNotFoundException("User not found in the database");	
		} else {
			log.error("User succesfully found in the database: {}", username);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> { 
				authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.User(
				user.getUserName(), user.getPassword(), authorities	);
	} 
	
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
