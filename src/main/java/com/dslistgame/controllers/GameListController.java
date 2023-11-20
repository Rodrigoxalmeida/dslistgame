package com.dslistgame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dslistgame.dto.GameListDTO;
import com.dslistgame.dto.GameMinDTO;
import com.dslistgame.dto.ReplacementDTO;
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
	public ResponseEntity<List<GameListDTO>> findAll(){
		List<GameListDTO> dto = service.findAll();
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<GameListDTO> findById(@PathVariable Long id) {
		GameListDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/{listId}/games")
	public ResponseEntity <List<GameMinDTO>> findByList(@PathVariable Long listId){
		List<GameMinDTO> dto = gameService.findByList(listId);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
		service.move(listId,body.getSourceIndex(), body.getDestinationIndex());
		
	}
	
	
	
}
