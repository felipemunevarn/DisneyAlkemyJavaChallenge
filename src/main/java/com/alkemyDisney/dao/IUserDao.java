package com.alkemyDisney.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemyDisney.model.User;

public interface IUserDao extends JpaRepository<User, Integer> {

	public Optional<User> findUserByUserName(String userName);
	
	public Boolean existsUserByUserName(String userName);
}
