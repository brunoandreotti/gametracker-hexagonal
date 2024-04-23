package com.brunoandreotti.gametrackerhexagonal.core.ports.out.gametrack;


import com.brunoandreotti.gametrackerhexagonal.core.domain.GameTrack;

public interface CreateGameTrackPort {

    GameTrack createGameTrack(GameTrack gameTrack);
}
