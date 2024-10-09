package com.estudos.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.demo.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
