package com.brunoandreotti.gametrackapi.core.ports.in;

import com.brunoandreotti.gametrackapi.core.domain.GameTrack;

import java.util.List;
import java.util.Optional;

public interface FindGameTrackByGameIdUseCasePort {

    List<GameTrack> find(Long gameId);
}
