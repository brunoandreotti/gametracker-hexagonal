package com.brunoandreotti.gametrackapi.adapters.out.repository;

import com.brunoandreotti.gametrackapi.core.domain.GameTrack;
import com.brunoandreotti.gametrackapi.core.ports.out.FindGameTrackPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FindGameTrackAdapter implements FindGameTrackPort {

    private final GameTrackRepository gameTrackRepository;

    public FindGameTrackAdapter(GameTrackRepository gameTrackRepository) {
        this.gameTrackRepository = gameTrackRepository;

    }


    @Override
    public List<GameTrack> findByGameId(Long gameId) {
        List<GameTrackEntity> gameTracks = gameTrackRepository.findByGameId(gameId);

        return gameTracks.stream().map(GameTrack::fromEntity).toList();
    }

    @Override
    public Optional<GameTrack> findById(Long id) {
        return gameTrackRepository.findById(id).map(GameTrack::fromEntity);
    }
}
