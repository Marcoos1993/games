package com.estudos.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.estudos.demo.entities.Game;
import com.estudos.demo.projections.GameMinProjections;

public interface GameRepository extends JpaRepository<Game, Long>{
	
	public Optional<Game> findById(Long id);
	
	@Query(nativeQuery = true, value ="SELECT tb_game.id, tb_game.title, tb_game.game_year, tb_game.img_url AS imgUrl, tb_game.short_description AS shortDescription, tb_belonging.position "
			+ "FROM tb_game "
			+ "INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id "
			+ "WHERE tb_belonging.list_id = :listId "
			+ "ORDER BY tb_belonging.position")
	public List<GameMinProjections> searchByList(Long listId);

}
