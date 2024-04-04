package com.brunoandreotti.gametrackerhexagonal.core.usecase;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.FindGameByNameUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.FindGamePort;

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
            throw new RuntimeException("Game not found");
        }

        return game.get();
    }
}
