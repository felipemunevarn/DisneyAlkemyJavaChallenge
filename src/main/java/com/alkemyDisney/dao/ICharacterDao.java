package com.alkemyDisney.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemyDisney.model.Charact;

public interface ICharacterDao extends JpaRepository<Charact, Integer>{

	List<Charact> findCharacterByName(String name);

//	List<Charact> findCharacterByAge(Integer age);
//
//	List<Charact> findCharacterByIdMovie(Integer idMovie);

}
