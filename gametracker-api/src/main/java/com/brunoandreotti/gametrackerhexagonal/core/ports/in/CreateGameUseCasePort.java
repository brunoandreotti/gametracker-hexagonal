package com.brunoandreotti.gametrackerhexagonal.core.ports.in;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;

public interface CreateGameUseCasePort {

    Game create(Game game);
}
