package com.brunoandreotti.gametrackerhexagonal.core.usecase;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.FindAllGamesUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.FindGamePort;

import java.util.List;

public class FindAllGamesUseCase implements FindAllGamesUseCasePort {

    private final FindGamePort findGamePort;

    public FindAllGamesUseCase(FindGamePort findGamePort) {
        this.findGamePort = findGamePort;
    }

    @Override
    public List<Game> findAll() {
        return findGamePort.findAllGames();
    }
}
