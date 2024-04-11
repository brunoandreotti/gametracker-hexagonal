package com.brunoandreotti.gametrackerhexagonal.adapters.in.controller.response;


import com.brunoandreotti.gametrackerhexagonal.core.domain.GameTrack;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameTrackResponseDTO {

    private Long id;

    private Integer hoursPlayed;

    private Integer rate;

    private Long gameId;

    public static GameTrackResponseDTO fromGameDomain(GameTrack gameTrack) { return new GameTrackResponseDTO(gameTrack.getId(), gameTrack.getRate(), gameTrack.getHoursPlayed(), gameTrack.getGameId()); }

    public GameTrack toGameTrackDomain() { return new GameTrack(this.id, this.rate, this.hoursPlayed, this.gameId);}
}
