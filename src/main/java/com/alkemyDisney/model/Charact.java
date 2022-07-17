package com.alkemyDisney.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Charact {

	@Id
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
	
	
}
