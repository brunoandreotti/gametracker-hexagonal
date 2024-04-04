package com.brunoandreotti.gametrackerhexagonal.adapters.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameEntity, Long> {

    GameEntity findByName(String name);
}
