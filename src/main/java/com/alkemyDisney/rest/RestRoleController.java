package com.alkemyDisney.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemyDisney.dao.IRoleDao;
import com.alkemyDisney.model.Role;

@RestController
@RequestMapping(value = "/roles")
public class RestRoleController {

	@Autowired
	@Qualifier("role")
	private IRoleDao repo;
	
	@GetMapping
	public List<Role> list(){
		return repo.findAll();
	}

	@PostMapping
	public Role insert(@RequestBody Role role) {
		return repo.save(role);
	}
	
	@DeleteMapping(value = "/{id_role}")
	public void deleteById(@PathVariable("id_role") Integer id) {
		repo.deleteById(id);
	}
	
}
