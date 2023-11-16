package com.dslistgame.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dslistgame.dto.GameMinDTO;
import com.dslistgame.entities.Game;
import com.dslistgame.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repository;
	
	public List<GameMinDTO> findAll(){
		List<Game> list = repository.findAll();
		List<GameMinDTO> dto = list.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}

}
