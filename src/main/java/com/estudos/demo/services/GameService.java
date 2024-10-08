package com.estudos.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estudos.demo.dto.GameDTO;
import com.estudos.demo.dto.GameMinDTO;
import com.estudos.demo.entities.Game;
import com.estudos.demo.projections.GameMinProjections;
import com.estudos.demo.repositories.GameRepository;

@Service
public class GameService {
	
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> list = gameRepository.findAll();
		List<GameMinDTO> result = list.stream().map(
				x -> new GameMinDTO(x)).collect(Collectors.toList());
		
		return result;
	}

	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);

		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> searchByList(Long listId){
		List<GameMinProjections> list = gameRepository.searchByList(listId);
		List<GameMinDTO> result = list.stream().map(x -> new GameMinDTO(x)).toList();
		
		return result;

}
	
}
