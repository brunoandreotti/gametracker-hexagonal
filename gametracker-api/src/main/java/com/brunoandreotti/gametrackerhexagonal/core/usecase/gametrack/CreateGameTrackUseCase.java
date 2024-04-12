package com.brunoandreotti.gametrackerhexagonal.core.usecase.gametrack;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.brunoandreotti.gametrackerhexagonal.core.domain.GameTrack;
import com.brunoandreotti.gametrackerhexagonal.core.exception.GameNotFoundException;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.gametrack.CreateGameTrackUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.game.FindGamePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.gametrack.CreateGameTrackPort;

import java.util.Optional;

public class CreateGameTrackUseCase implements CreateGameTrackUseCasePort {

    private final FindGamePort findGamePort;

    private final CreateGameTrackPort createGameTrackPort;

    public CreateGameTrackUseCase(FindGamePort findGamePort, CreateGameTrackPort createGameTrackPort) {
        this.findGamePort = findGamePort;
        this.createGameTrackPort = createGameTrackPort;
    }

    @Override
    public GameTrack create(GameTrack gameTrack) {

        Optional<Game> game = findGamePort.findGameById(gameTrack.getGameId());

        if (game.isEmpty()) {
            throw new GameNotFoundException("Game not found");
        }


        return createGameTrackPort.createGameTrack(gameTrack);
    }
}
