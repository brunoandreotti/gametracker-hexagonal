package com.brunoandreotti.gametrackerhexagonal.core.usecase.gametrack;

import com.brunoandreotti.gametrackerhexagonal.core.ports.in.gametrack.DeleteGameTrackUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.gametrack.DeleteGameTrackPort;

public class DeleteGameTrackUseCase implements DeleteGameTrackUseCasePort {


    private final DeleteGameTrackPort deleteGameTrackPort;

    public DeleteGameTrackUseCase(DeleteGameTrackPort deleteGameTrackPort) {
        this.deleteGameTrackPort = deleteGameTrackPort;
    }

    @Override
    public void delete(Long id) {
        deleteGameTrackPort.deleteGameTracker(id);
    }
}
