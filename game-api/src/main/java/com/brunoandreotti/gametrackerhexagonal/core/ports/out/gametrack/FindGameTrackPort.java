package com.brunoandreotti.gametrackerhexagonal.core.ports.out.gametrack;

import com.brunoandreotti.gametrackerhexagonal.core.domain.GameTrack;

import java.util.List;

public interface FindGameTrackPort {

    List<GameTrack> findGameTrackByGameId(Long gameId);
}
