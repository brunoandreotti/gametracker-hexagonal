package com.brunoandreotti.gametrackerhexagonal.adapters.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<GameEntity, Long> {

    Optional<GameEntity> findByName(String name);
}
