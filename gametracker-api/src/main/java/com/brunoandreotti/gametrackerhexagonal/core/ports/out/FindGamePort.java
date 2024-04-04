package com.brunoandreotti.gametrackerhexagonal.core.ports.out;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;

import java.util.List;

public interface FindGamePort {

    Game findGameByName(String name);

    List<Game> findAllGames();
}
