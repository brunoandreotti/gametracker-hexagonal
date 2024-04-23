package com.brunoandreotti.gametrackerhexagonal.core.usecase.game;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.brunoandreotti.gametrackerhexagonal.core.exception.GameNotFoundException;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.game.FindGameByNameUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.game.FindGamePort;

import java.util.Optional;

public class FindGameByNameUseCase implements FindGameByNameUseCasePort {

    private final FindGamePort findGamePort;

    public FindGameByNameUseCase(FindGamePort findGamePort) {
        this.findGamePort = findGamePort;
    }

    @Override
    public Game findByName(String name) {
        Optional<Game> game = findGamePort.findGameByName(name);

        if (game.isEmpty()) {
            throw new GameNotFoundException("Game not found");
        }

        return game.get();
    }
}
