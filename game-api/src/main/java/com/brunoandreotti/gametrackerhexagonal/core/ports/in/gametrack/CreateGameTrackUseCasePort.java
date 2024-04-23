package com.brunoandreotti.gametrackerhexagonal.core.ports.in.gametrack;

import com.brunoandreotti.gametrackerhexagonal.core.domain.GameTrack;

public interface CreateGameTrackUseCasePort {

    GameTrack create(GameTrack gameTrack);
}
