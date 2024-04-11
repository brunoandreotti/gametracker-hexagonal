package com.brunoandreotti.gametrackapi.core.ports.in;

import com.brunoandreotti.gametrackapi.core.domain.GameTrack;

public interface CreateGameTrackUseCasePort {

    GameTrack create(GameTrack gameTrack);
}
