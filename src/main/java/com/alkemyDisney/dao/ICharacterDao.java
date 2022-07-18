package com.alkemyDisney.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemyDisney.model.Charact;

@Qualifier("character")
public interface ICharacterDao extends JpaRepository<Charact, Integer>{

	List<Charact> findCharacterByName(String name);

	List<Charact> findCharacterByAge(int i);
//
//	List<Charact> findCharacterByIdMovie(Integer idMovie);

}
