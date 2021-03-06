package com.alkemyDisney.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Charact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCharacter;
	
	@Column(name = "image", length = 255)
	private String image;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "weight")
	private double weight;
	
	@Column(name = "history", length = 1048)
	private String history;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "charact_movie", 
    joinColumns = @JoinColumn(name = "idCharacter", referencedColumnName = "idCharacter"), 
    inverseJoinColumns = @JoinColumn(name = "idMovie", referencedColumnName = "idMovie"))
	private Set<Movie> movies = new HashSet<>();

	public Charact() {
		super();
	}

	public Charact(int idCharacter, String image, String name, int age, double weight, String history,
			Set<Movie> movies) {
		super();
		this.idCharacter = idCharacter;
		this.image = image;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.history = history;
		this.movies = movies;
	}

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

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	public void associateMovie(Movie movie) {
		movies.add(movie);		
	}

	@Override
	public String toString() {
		return "Charact [idCharacter=" + idCharacter + ", image=" + image + ", name=" + name + ", age=" + age
				+ ", weight=" + weight + ", history=" + history + ", movies=" + movies + "]";
	}
		
}
