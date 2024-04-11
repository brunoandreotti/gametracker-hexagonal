package com.brunoandreotti.gametrackerhexagonal.core.usecase.game;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.brunoandreotti.gametrackerhexagonal.core.exception.GameNotFoundException;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.game.DeleteGameUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.game.DeleteGamePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.game.FindGamePort;

import java.util.Optional;

public class DeleteGameUseCase implements DeleteGameUseCasePort {

    private final FindGamePort findGamePort;
    private final DeleteGamePort deleteGamePort;

    public DeleteGameUseCase(FindGamePort findGamePort, DeleteGamePort deleteGamePort) {
        this.findGamePort = findGamePort;
        this.deleteGamePort = deleteGamePort;

    }

    @Override
    public void delete(Long id) {
        Optional<Game> gameExists = findGamePort.findGameById(id);

        if (gameExists.isEmpty()) {
            throw  new GameNotFoundException("Game not found");
        }

       deleteGamePort.deleteGameById(id);


    }
}
