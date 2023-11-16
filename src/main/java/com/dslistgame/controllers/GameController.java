package com.dslistgame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	
}
