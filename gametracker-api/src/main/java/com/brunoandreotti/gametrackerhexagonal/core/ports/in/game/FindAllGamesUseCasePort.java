package com.brunoandreotti.gametrackerhexagonal.core.ports.in.game;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;

import java.util.List;

public interface FindAllGamesUseCasePort {

    List<Game> findAll();
}
