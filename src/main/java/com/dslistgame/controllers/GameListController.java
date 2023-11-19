package com.dslistgame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dslistgame.dto.GameListDTO;
import com.dslistgame.services.GameListService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService service;
	
	@GetMapping
	ResponseEntity<List<GameListDTO>> findAll(){
		List<GameListDTO> dto = service.findAll();
		return ResponseEntity.ok().body(dto);
	}
	
	
}
