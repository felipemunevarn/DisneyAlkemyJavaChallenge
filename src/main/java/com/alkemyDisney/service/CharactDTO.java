package com.alkemyDisney.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.alkemyDisney.model.Charact;
import com.alkemyDisney.model.Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Service
public class CharactDTO {
	private int idCharacter;
	private String image;
	private String name;
	private int age;
	private double weight;
	private String history;
	private Set<MovieDTO> movies = new HashSet<>();
	
	public CharactDTO() {}
	
	public int getIdCharacter() {
		return idCharacter;
	}
	public void setIdCharacter(int idCharacter) {
		this.idCharacter = idCharacter;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public Set<MovieDTO> getMovies() {
		return movies;
	}
	public void setMovies(Set<MovieDTO> movies) {
		this.movies = movies;
	}
	
}
