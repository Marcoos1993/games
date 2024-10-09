package com.estudos.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.demo.dto.GameMinDTO;
import com.estudos.demo.entities.Game;
import com.estudos.demo.repositories.GameRepository;

@Service
public class GameService {
	
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		
		List<Game> list = gameRepository.findAll();
		List<GameMinDTO> result = list.stream().map(x -> new GameMinDTO(x)).collect(Collectors.toList());
		
		
		return result;
	}

}
