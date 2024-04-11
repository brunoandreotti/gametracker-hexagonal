package com.brunoandreotti.gametrackapi.core.ports.out;

import com.brunoandreotti.gametrackapi.core.domain.GameTrack;

public interface SaveGameTrackPort {

    GameTrack save(GameTrack gameTrack);
}
