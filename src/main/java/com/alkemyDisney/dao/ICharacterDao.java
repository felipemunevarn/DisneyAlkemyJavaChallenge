package com.alkemyDisney.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alkemyDisney.model.Charact;

@Qualifier("character")
public interface ICharacterDao extends JpaRepository<Charact, Integer>{

	List<Charact> findCharacterByName(String name);

	List<Charact> findCharacterByAge(int i);

	List<Charact> findCharacterByIdCharacter(int idCharacter);

	@Query(value = "SELECT * FROM charact c "
			+ "INNER JOIN charact_movie cm "
			+ "ON c.id_character = cm.id_character "
			+ "AND cm.id_movie = :idMovie", nativeQuery = true)
	List<Charact> findCharacterByMovies(@Param("idMovie") String idMovie);
}
