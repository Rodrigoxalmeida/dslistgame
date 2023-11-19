package com.dslistgame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dslistgame.dto.GameDTO;
import com.dslistgame.dto.GameMinDTO;
import com.dslistgame.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService service;
	
	@GetMapping
	ResponseEntity<List<GameMinDTO>> findAll(){
		List<GameMinDTO> dto = service.findAll();
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/{id}")
	ResponseEntity<GameDTO> findById(@PathVariable Long id){
		GameDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	
}
