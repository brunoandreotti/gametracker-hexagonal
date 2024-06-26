package com.brunoandreotti.gametrackerhexagonal.core.domain;



public class GameTrack {

    public GameTrack(Long id, Integer rate, Integer hoursPlayed, Long gameId) {
        this.id = id;
        this.rate = rate;
        this.hoursPlayed = hoursPlayed;
        this.gameId = gameId;
    }

    public GameTrack(Integer rate, Integer hoursPlayed, Long gameId) {

        this.rate = rate;
        this.hoursPlayed = hoursPlayed;
        this.gameId = gameId;
    }

    public GameTrack() {
    }

    private Long id;

    private Integer rate;

    private Integer hoursPlayed;

    private Long gameId;

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
