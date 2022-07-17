package com.alkemyDisney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alkemyDisney.dao.ICharacterDao;
import com.alkemyDisney.model.Charact;

@Controller
public class CharacterController {
	
	@Autowired
	private ICharacterDao repo;
	
	@GetMapping("/characters2")
	public String greet(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
	
		Charact c = new Charact();
		c.setIdCharacter(1);
		c.setAge(33);
		c.setHistory("This is my history");
		c.setImage("ref.image.jpg");
		c.setName("Miguelito");
		c.setWeight(53.4);
		
		repo.save(c);
		
		model.addAttribute("name", name);
		return "Hello";
	}
}
