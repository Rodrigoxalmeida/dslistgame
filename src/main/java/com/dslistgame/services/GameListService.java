package com.dslistgame.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dslistgame.dto.GameListDTO;
import com.dslistgame.entities.GameList;
import com.dslistgame.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> list = repository.findAll();
		List<GameListDTO> dto = list.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
	
}
