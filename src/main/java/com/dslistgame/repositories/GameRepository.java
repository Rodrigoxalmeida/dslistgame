package com.dslistgame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dslistgame.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
