package com.alkemyDisney.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUser;
	
	private String userName;
	
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", 
    joinColumns = @JoinColumn(name = "idUser", referencedColumnName = "idUser"), 
    inverseJoinColumns = @JoinColumn(name = "idRole", referencedColumnName = "idRole"))
	private Set<Role> roles = new HashSet<>();

	public User() {
		super();
	}

	public User(int idUser, String userName, String password, Set<Role> roles) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void associateRole(Role role) {
		roles.add(role);		
	}
	
}
