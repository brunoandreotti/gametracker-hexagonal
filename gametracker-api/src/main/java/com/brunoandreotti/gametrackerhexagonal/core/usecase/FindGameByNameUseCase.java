package com.brunoandreotti.gametrackerhexagonal.core.usecase;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.FindGameByNameUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.FindGamePort;

public class FindGameByNameUseCase implements FindGameByNameUseCasePort {

    private final FindGamePort findGamePort;

    public FindGameByNameUseCase(FindGamePort findGamePort) {
        this.findGamePort = findGamePort;
    }

    @Override
    public Game findByName(String name) {
        Game game = findGamePort.findGameByName(name);

        if (game == null) {
            throw new RuntimeException("Game not found");
        }

        return game;
    }
}
