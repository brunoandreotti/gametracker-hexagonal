package com.brunoandreotti.gametrackerhexagonal.core.ports.out.game;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;

public interface SaveGamePort {

    Game saveGame(Game game);
}
