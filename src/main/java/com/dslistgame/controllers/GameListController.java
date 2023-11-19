package com.dslistgame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dslistgame.dto.GameListDTO;
import com.dslistgame.dto.GameMinDTO;
import com.dslistgame.services.GameListService;
import com.dslistgame.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService service;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	ResponseEntity<List<GameListDTO>> findAll(){
		List<GameListDTO> dto = service.findAll();
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/{listId}/games")
	ResponseEntity <List<GameMinDTO>> findByList(@PathVariable Long listId){
		List<GameMinDTO> dto = gameService.findByList(listId);
		return ResponseEntity.ok().body(dto);
	}
	
	
}
