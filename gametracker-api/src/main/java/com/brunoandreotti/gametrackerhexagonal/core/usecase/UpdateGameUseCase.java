package com.brunoandreotti.gametrackerhexagonal.core.usecase;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.brunoandreotti.gametrackerhexagonal.core.exception.GameNotFoundException;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.UpdateGameUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.FindGamePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.SaveGamePort;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateGameUseCase implements UpdateGameUseCasePort {

    public final FindGamePort findGamePort;
    public final SaveGamePort saveGamePort;

    public UpdateGameUseCase(FindGamePort findGamePort, SaveGamePort saveGamePort) {
        this.findGamePort = findGamePort;
        this.saveGamePort = saveGamePort;
    }

    @Override
    public Game updateById(Game updatedGame, Long id) {
        Optional<Game> game = findGamePort.findGameById(id);

        if (game.isEmpty()) {
            throw new GameNotFoundException("Game not found");
        }

        BeanUtils.copyProperties(updatedGame, game.get(), "id");

        return saveGamePort.saveGame(game.get());
    }
}
