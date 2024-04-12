package com.brunoandreotti.gametrackerhexagonal.adapters.out.client;

import com.brunoandreotti.gametrackerhexagonal.adapters.in.response.GameTrackResponseDTO;

import com.brunoandreotti.gametrackerhexagonal.core.domain.GameTrack;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.gametrack.FindGameTrackPort;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FindGameTrackAdapter implements FindGameTrackPort {

    public final GameTrackClient gameTrackClient;


    public FindGameTrackAdapter(GameTrackClient gameTrackClient) {
        this.gameTrackClient = gameTrackClient;

    }

    @Override
    public List<GameTrack> findGameTrackByGameId(Long gameId) {
        return gameTrackClient.getGameTrackByGameId(gameId).stream().map(GameTrackResponseDTO::toGameTrackDomain).toList();
    }
}
