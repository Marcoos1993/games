package com.estudos.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estudos.demo.dto.GameListDTO;
import com.estudos.demo.entities.GameList;
import com.estudos.demo.projections.GameMinProjections;
import com.estudos.demo.repositories.GameListRepository;
import com.estudos.demo.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> list = gameListRepository.findAll();
		List<GameListDTO> result = list.stream().map(x -> new GameListDTO(x)).toList();
		
		return result;
	}
	
	@Transactional(readOnly = true)
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjections> list = gameRepository.searchByList(listId);
		
		GameMinProjections obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

		for( int i = min; i <= max; i++) {
			
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
			
		}

	}

}
