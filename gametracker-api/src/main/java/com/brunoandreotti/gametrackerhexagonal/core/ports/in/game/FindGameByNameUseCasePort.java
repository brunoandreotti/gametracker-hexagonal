package com.brunoandreotti.gametrackerhexagonal.core.ports.in.game;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;

public interface FindGameByNameUseCasePort {

    Game findByName(String name);
}
