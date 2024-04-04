package com.brunoandreotti.gametrackerhexagonal.core.ports.out;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;

public interface SaveGamePort {

    Game saveGame(Game game);
}
