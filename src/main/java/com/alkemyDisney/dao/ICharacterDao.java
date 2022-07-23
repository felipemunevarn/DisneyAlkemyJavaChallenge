package com.alkemyDisney.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alkemyDisney.model.Charact;

@Qualifier("character")
public interface ICharacterDao extends JpaRepository<Charact, Integer>{

	@Query(value = "SELECT * FROM charact WHERE name = :name", nativeQuery = true)
	List<Charact> findCharacterByName(@Param("name") String name);

	@Query(value = "SELECT * FROM charact WHERE age = :age", nativeQuery = true)
	List<Charact> findCharacterByAge(@Param("age") int age);

	@Query(value = "SELECT * FROM charact c "
			+ "INNER JOIN charact_movie cm "
			+ "ON c.id_character = cm.id_character "
			+ "AND cm.id_movie = :idMovie", nativeQuery = true)
	List<Charact> findCharacterByMovies(@Param("idMovie") String idMovie);
	
	List<Charact> findCharacterByIdCharacter(int idCharacter);
}
