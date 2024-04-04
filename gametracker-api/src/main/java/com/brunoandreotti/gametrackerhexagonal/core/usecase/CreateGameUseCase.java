package com.brunoandreotti.gametrackerhexagonal.core.usecase;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.CreateGameUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.FindGamePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.SaveGamePort;

import java.util.Optional;


public class CreateGameUseCase implements CreateGameUseCasePort {

    private final SaveGamePort saveGamePort;
    private final FindGamePort findGamePort;

    public CreateGameUseCase(SaveGamePort saveGamePort, FindGamePort findGamePort) {
        this.saveGamePort = saveGamePort;
        this.findGamePort = findGamePort;
    }

    @Override
    public Game create(Game game) {
            Optional<Game> gameExists = findGamePort.findGameByName(game.getName());

            if (gameExists.isPresent()) {
                throw new RuntimeException("Game already exists");
            }

            return saveGamePort.saveGame(game);
    }


}
