package com.estudos.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.demo.dto.GameListDTO;
import com.estudos.demo.dto.GameMinDTO;
import com.estudos.demo.services.GameListService;
import com.estudos.demo.services.GameService;

@RestController
@RequestMapping(value = "/lists")

public class GameListController {
	
	@Autowired
	private GameListService gameListservice;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		return gameListservice.findAll();
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findListById(@PathVariable Long listId){
		return gameService.searchByList(listId);
	}

}
