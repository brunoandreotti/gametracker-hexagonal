package com.brunoandreotti.gametrackerhexagonal.adapters.out.client;

import com.brunoandreotti.gametrackerhexagonal.adapters.in.request.GameTrackRequestDTO;

import com.brunoandreotti.gametrackerhexagonal.core.domain.GameTrack;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.gametrack.CreateGameTrackPort;
import org.springframework.stereotype.Component;

@Component
public class CreateGameTrackAdapter implements CreateGameTrackPort {

    private final GameTrackClient gameTrackClient;

    public CreateGameTrackAdapter(GameTrackClient gameTrackClient) {
        this.gameTrackClient = gameTrackClient;
    }

    @Override
    public GameTrack createGameTrack(GameTrack gameTrack) {

        return gameTrackClient.createGameTrack(GameTrackRequestDTO.fromGameTrackDomain(gameTrack)).toGameTrackDomain();

    }
}
