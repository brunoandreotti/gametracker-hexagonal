package com.brunoandreotti.gametrackerhexagonal.config.circuitBreaker;

import com.brunoandreotti.gametrackerhexagonal.adapters.in.response.GameTrackResponseDTO;


import java.util.List;

public class FindGameTrackCBConfig {

    List<GameTrackResponseDTO> returnStandardResponse() {


        return List.of(new GameTrackResponseDTO(999L, 0, 0, 999L));
    }
}
