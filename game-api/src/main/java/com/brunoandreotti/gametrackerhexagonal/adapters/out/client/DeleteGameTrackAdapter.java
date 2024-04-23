package com.brunoandreotti.gametrackerhexagonal.adapters.out.client;

import com.brunoandreotti.gametrackerhexagonal.core.ports.out.gametrack.DeleteGameTrackPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteGameTrackAdapter implements DeleteGameTrackPort {

    private final GameTrackClient gameTrackClient;

    public DeleteGameTrackAdapter(GameTrackClient gameTrackClient) {
        this.gameTrackClient = gameTrackClient;
    }

    @Override
    public void deleteGameTracker(Long gameTrackerId) {
        gameTrackClient.deleteGameTrackById(gameTrackerId);
    }
}
