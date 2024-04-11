package com.brunoandreotti.gametrackapi.core.ports.out;

import com.brunoandreotti.gametrackapi.core.domain.GameTrack;

import java.util.List;
import java.util.Optional;

public interface FindGameTrackPort {

    List<GameTrack> findByGameId(Long gameId);

    Optional<GameTrack> findById(Long id);
}
