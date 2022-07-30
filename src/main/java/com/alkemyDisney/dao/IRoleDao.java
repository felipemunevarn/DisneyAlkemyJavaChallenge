package com.alkemyDisney.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemyDisney.model.Role;

@Qualifier("role")
public interface IRoleDao extends JpaRepository<Role, Integer> {

	public Role findRoleByName(String name);
	
	public Boolean existsRoleByName(String name);
}
