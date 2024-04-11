package com.brunoandreotti.gametrackapi.adapters.out.repository;

import com.brunoandreotti.gametrackapi.core.domain.GameTrack;
import com.brunoandreotti.gametrackapi.core.ports.out.SaveGameTrackPort;
import org.springframework.stereotype.Component;

@Component
public class SaveGameTrackAdapter implements SaveGameTrackPort {

    private final GameTrackRepository gameTrackRepository;

    public SaveGameTrackAdapter(GameTrackRepository gameTrackRepository) {
        this.gameTrackRepository = gameTrackRepository;
    }

    @Override
    public GameTrack save(GameTrack gameTrack) {
        GameTrackEntity gameTrackEntity = new GameTrackEntity(gameTrack);
        GameTrackEntity savedGameTrackEntity = gameTrackRepository.save(gameTrackEntity);
        gameTrack.setId(savedGameTrackEntity.getId());
        return gameTrack;
    }
}
