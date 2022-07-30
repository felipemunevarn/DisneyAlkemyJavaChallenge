package com.alkemyDisney.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemyDisney.model.User;

@Qualifier("user")
public interface IUserDao extends JpaRepository<User, Integer> {

	public User findUserByUserName(String userName);
	
	public Boolean existsUserByUserName(String userName);
}
