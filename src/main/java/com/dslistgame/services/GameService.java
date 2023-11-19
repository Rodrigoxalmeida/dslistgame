package com.dslistgame.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dslistgame.dto.GameDTO;
import com.dslistgame.dto.GameMinDTO;
import com.dslistgame.entities.Game;
import com.dslistgame.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> list = repository.findAll();
		List<GameMinDTO> dto = list.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game entity = repository.findById(id).get();
		GameDTO dto = new GameDTO(entity);
		return dto;
	}

}
