package com.brunoandreotti.gametrackapi.adapters.in.controller.request;

import com.brunoandreotti.gametrackapi.core.domain.GameTrack;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameTrackRequestDTO {

    private Integer hoursPlayed;

    private Integer rate;

    private Long gameId;

    public GameTrack toGameTrackDomain() { return new GameTrack(this.hoursPlayed, this.rate, this.gameId); }
}
