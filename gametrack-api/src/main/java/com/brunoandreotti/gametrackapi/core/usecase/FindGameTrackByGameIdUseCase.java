package com.brunoandreotti.gametrackapi.core.usecase;

import com.brunoandreotti.gametrackapi.core.domain.GameTrack;
import com.brunoandreotti.gametrackapi.core.ports.in.FindGameTrackByGameIdUseCasePort;
import com.brunoandreotti.gametrackapi.core.ports.out.FindGameTrackPort;

import java.util.List;
import java.util.Optional;

public class FindGameTrackByGameIdUseCase implements FindGameTrackByGameIdUseCasePort {

    private final FindGameTrackPort findGameTrackPort;

    public FindGameTrackByGameIdUseCase(FindGameTrackPort findGameTrackPort) {
        this.findGameTrackPort = findGameTrackPort;
    }

    @Override
    public List<GameTrack> find(Long gameId) {
        return findGameTrackPort.findByGameId(gameId);
    }
}
