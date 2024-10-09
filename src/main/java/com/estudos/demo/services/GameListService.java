package com.estudos.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estudos.demo.dto.GameListDTO;
import com.estudos.demo.entities.GameList;
import com.estudos.demo.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> list = repository.findAll();
		List<GameListDTO> result = list.stream().map(x -> new GameListDTO(x)).toList();
		
		return result;
		
	}
	

}
