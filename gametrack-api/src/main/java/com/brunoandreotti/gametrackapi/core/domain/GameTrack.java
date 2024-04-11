package com.brunoandreotti.gametrackapi.core.domain;

import com.brunoandreotti.gametrackapi.adapters.out.repository.GameTrackEntity;

public class GameTrack {

    private Long id;

    private Integer hoursPlayed;

    private Integer rate;

    private Long gameId;



    public GameTrack(Long id, Integer rate, Integer hoursPlayed, Long gameId) {
        this.id = id;
        this.rate = rate;
        this.hoursPlayed = hoursPlayed;
        this.gameId = gameId;
    }

    public GameTrack(Long gameId) {
            this.gameId = gameId;
    }

    public GameTrack(Integer hoursPlayed, Integer rate, Long gameId) {
        this.hoursPlayed = hoursPlayed;
        this.rate = rate;
        this.gameId = gameId;
    }

    public static GameTrack fromEntity(GameTrackEntity gameTrackEntity) {

        return new GameTrack(gameTrackEntity.getId(), gameTrackEntity.getRate(), gameTrackEntity.getHoursPlayed(), gameTrackEntity.getGameId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(Integer hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}
