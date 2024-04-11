package com.brunoandreotti.gametrackapi.core.usecase;

import com.brunoandreotti.gametrackapi.core.domain.GameTrack;
import com.brunoandreotti.gametrackapi.core.ports.in.CreateGameTrackUseCasePort;
import com.brunoandreotti.gametrackapi.core.ports.out.SaveGameTrackPort;

public class CreateGameTrackUseCase implements CreateGameTrackUseCasePort {

    private final SaveGameTrackPort saveGameTrackPort;

    public CreateGameTrackUseCase(SaveGameTrackPort saveGameTrackPort) {
        this.saveGameTrackPort = saveGameTrackPort;
    }


    @Override
    public GameTrack create(GameTrack gameTrack) {
        return saveGameTrackPort.save(gameTrack);
    }
}
