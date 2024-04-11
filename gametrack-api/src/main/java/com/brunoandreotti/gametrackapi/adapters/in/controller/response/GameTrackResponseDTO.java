package com.brunoandreotti.gametrackapi.adapters.in.controller.response;

import com.brunoandreotti.gametrackapi.core.domain.GameTrack;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameTrackResponseDTO {

    private Long id;

    private Integer hoursPlayed;

    private Integer rate;

    private Long gameId;

    public static GameTrackResponseDTO fromGameDomain(GameTrack gameTrack) { return new GameTrackResponseDTO(gameTrack.getId(), gameTrack.getHoursPlayed(), gameTrack.getRate(), gameTrack.getGameId()); }
}
