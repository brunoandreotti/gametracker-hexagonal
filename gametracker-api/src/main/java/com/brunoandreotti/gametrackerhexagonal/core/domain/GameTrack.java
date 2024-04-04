package com.brunoandreotti.gametrackerhexagonal.core.domain;



public class GameTrack {

    public GameTrack(Long id, GameStatus status, Double rate, Double hoursPlayed) {
        this.id = id;
        this.status = status;
        this.rate = rate;
        this.hoursPlayed = hoursPlayed;
    }

    public GameTrack() {
    }

    private Long id;


    private GameStatus status = GameStatus.TO_PLAY;


    private Double rate;


    private Double hoursPlayed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(Double hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }
}
