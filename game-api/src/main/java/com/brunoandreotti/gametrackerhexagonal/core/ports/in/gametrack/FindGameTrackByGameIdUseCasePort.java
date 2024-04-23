package com.brunoandreotti.gametrackerhexagonal.core.ports.in.gametrack;

import com.brunoandreotti.gametrackerhexagonal.core.domain.GameTrack;

import java.util.List;

public interface FindGameTrackByGameIdUseCasePort {

    List<GameTrack> find(Long gameId);
}
