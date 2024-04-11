package com.brunoandreotti.gametrackapi.core.usecase;

import com.brunoandreotti.gametrackapi.core.domain.GameTrack;
import com.brunoandreotti.gametrackapi.core.exception.GameTrackNotFoundException;
import com.brunoandreotti.gametrackapi.core.ports.in.DeleteGameTrackByIdUseCasePort;
import com.brunoandreotti.gametrackapi.core.ports.out.DeleteGameTrackPort;
import com.brunoandreotti.gametrackapi.core.ports.out.FindGameTrackPort;

import java.util.Optional;

public class DeleteGameTrackByIdUseCase implements DeleteGameTrackByIdUseCasePort {

    private final DeleteGameTrackPort deleteGameTrackPort;

    private final FindGameTrackPort findGameTrackPort;

    public DeleteGameTrackByIdUseCase(DeleteGameTrackPort deleteGameTrackPort, FindGameTrackPort findGameTrackPort) {
        this.deleteGameTrackPort = deleteGameTrackPort;
        this.findGameTrackPort = findGameTrackPort;
    }


    @Override
    public void delete(Long id) {
        Optional<GameTrack> gameTrack = findGameTrackPort.findById(id);

        if (gameTrack.isEmpty()) {
            throw new GameTrackNotFoundException("GameTrack not found");
        }

        deleteGameTrackPort.deleteById(id);
    }
}
