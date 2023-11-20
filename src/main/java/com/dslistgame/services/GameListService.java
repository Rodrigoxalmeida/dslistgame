package com.dslistgame.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dslistgame.dto.GameListDTO;
import com.dslistgame.entities.GameList;
import com.dslistgame.projections.GameMinProjection;
import com.dslistgame.repositories.GameListRepository;
import com.dslistgame.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository repository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> list = repository.findAll();
		List<GameListDTO> dto = list.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
	
	public GameListDTO findById(Long id) {
		GameList obj = repository.findById(id).get();
		return new GameListDTO(obj);
		
	}
	
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex ) {
		
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex ,obj);
		
		int min = sourceIndex < destinationIndex ?  sourceIndex : destinationIndex; 
		int max = sourceIndex < destinationIndex ?  destinationIndex : sourceIndex; 
		
		for(int i = min; i <= max; i++) {
			repository.updateBelongingPosition(listId,list.get(i).getId(), i);
		}
	}
	
}
