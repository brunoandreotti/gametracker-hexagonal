package com.brunoandreotti.gametrackerhexagonal.core.ports.out;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;

import java.util.List;
import java.util.Optional;

public interface FindGamePort {

    Optional<Game> findGameByName(String name);

    List<Game> findAllGames();
}
