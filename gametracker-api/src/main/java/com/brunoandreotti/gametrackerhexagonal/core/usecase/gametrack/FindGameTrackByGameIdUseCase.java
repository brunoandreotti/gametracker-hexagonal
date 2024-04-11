package com.brunoandreotti.gametrackerhexagonal.core.usecase.gametrack;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.brunoandreotti.gametrackerhexagonal.core.domain.GameTrack;
import com.brunoandreotti.gametrackerhexagonal.core.exception.GameNotFoundException;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.gametrack.FindGameTrackByGameIdUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.game.FindGamePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.gametrack.FindGameTrackPort;

import java.util.List;
import java.util.Optional;

public class FindGameTrackByGameIdUseCase implements FindGameTrackByGameIdUseCasePort {

    private final FindGamePort findGamePort;

    private final FindGameTrackPort findGameTrackPort;

    public FindGameTrackByGameIdUseCase(FindGamePort findGamePort, FindGameTrackPort findGameTrackPort) {
        this.findGamePort = findGamePort;
        this.findGameTrackPort = findGameTrackPort;
    }


    @Override
    public List<GameTrack> find(Long gameId) {
        Optional<Game> game = findGamePort.findGameById(gameId);

        if (game.isEmpty()) {
            throw new GameNotFoundException("Game not found");
        }


        return findGameTrackPort.findGameIdById(gameId);
    }
}
