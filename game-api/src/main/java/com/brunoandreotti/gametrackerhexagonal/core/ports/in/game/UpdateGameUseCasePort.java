package com.brunoandreotti.gametrackerhexagonal.core.ports.in.game;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;

public interface UpdateGameUseCasePort {

    Game updateById(Game updatedGame, Long id);
}
