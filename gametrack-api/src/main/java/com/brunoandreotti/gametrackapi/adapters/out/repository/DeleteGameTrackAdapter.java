package com.brunoandreotti.gametrackapi.adapters.out.repository;

import com.brunoandreotti.gametrackapi.core.ports.out.DeleteGameTrackPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteGameTrackAdapter implements DeleteGameTrackPort {

    private final GameTrackRepository gameTrackRepository;

    public DeleteGameTrackAdapter(GameTrackRepository gameTrackRepository) {
        this.gameTrackRepository = gameTrackRepository;
    }

    @Override
    public void deleteById(Long id) {
        gameTrackRepository.deleteById(id);
    }
}
