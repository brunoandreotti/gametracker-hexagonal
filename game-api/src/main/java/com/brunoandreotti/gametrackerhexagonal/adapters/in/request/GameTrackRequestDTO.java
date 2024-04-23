package com.brunoandreotti.gametrackerhexagonal.adapters.in.request;



import com.brunoandreotti.gametrackerhexagonal.core.domain.GameTrack;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameTrackRequestDTO {

    private Integer hoursPlayed;

    private Integer rate;

    private Long gameId;

    public GameTrack toGameTrackDomain() {
        return new GameTrack(this.getRate(), this.getHoursPlayed(), this.getGameId());
    }

    public static GameTrackRequestDTO fromGameTrackDomain(GameTrack gameTrack) {
        return new GameTrackRequestDTO(gameTrack.getRate(), gameTrack.getHoursPlayed(), gameTrack.getGameId());
    }
}
