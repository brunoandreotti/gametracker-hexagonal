package com.brunoandreotti.gametrackerhexagonal.core.ports.out.game;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;

import java.util.List;
import java.util.Optional;

public interface FindGamePort {

    Optional<Game> findGameByName(String name);

    Optional<Game> findGameById(Long id);

    List<Game> findAllGames();
}
