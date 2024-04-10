package com.brunoandreotti.gametrackerhexagonal.core.ports.in;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;

public interface UpdateGameUseCasePort {

    Game updateById(Game updatedGame, Long id);
}
