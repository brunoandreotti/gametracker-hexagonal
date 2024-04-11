package com.brunoandreotti.gametrackerhexagonal.core.usecase.game;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.brunoandreotti.gametrackerhexagonal.core.exception.GameAlreadyExistsException;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.game.CreateGameUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.game.FindGamePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.game.SaveGamePort;

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
                throw new GameAlreadyExistsException("Game already exists");
            }

            return saveGamePort.saveGame(game);
    }


}
