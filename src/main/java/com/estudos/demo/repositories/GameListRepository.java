package com.estudos.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.demo.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

	public List<GameList> findAll();
}
