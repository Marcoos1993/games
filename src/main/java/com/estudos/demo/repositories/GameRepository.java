package com.estudos.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.demo.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	
	public Optional<Game> findById(Long id);

}
