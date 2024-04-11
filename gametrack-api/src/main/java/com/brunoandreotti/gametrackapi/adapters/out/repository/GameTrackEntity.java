package com.brunoandreotti.gametrackapi.adapters.out.repository;

import com.brunoandreotti.gametrackapi.core.domain.GameTrack;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_game_track")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameTrackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer hoursPlayed;

    @Column
    private Integer rate;

    @Column
    private Long gameId;

    public GameTrackEntity(GameTrack gameTrack) {
        this.id = gameTrack.getId();
        this.gameId = gameTrack.getGameId();
        this.rate = gameTrack.getRate();
        this.hoursPlayed = gameTrack.getHoursPlayed();
    }
}
