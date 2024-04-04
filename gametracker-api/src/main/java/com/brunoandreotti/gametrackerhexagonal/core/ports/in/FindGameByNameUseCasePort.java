package com.brunoandreotti.gametrackerhexagonal.core.ports.in;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;

public interface FindGameByNameUseCasePort {

    Game findByName(String name);
}
