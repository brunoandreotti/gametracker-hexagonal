package com.brunoandreotti.gametrackerhexagonal.core.domain;


import com.brunoandreotti.gametrackerhexagonal.adapters.out.repository.GameEntity;

public class Game {

    public Game(Long id, String name, Integer averageRate, String imageUrl) {
        this.id = id;
        this.name = name;
        this.averageRate = averageRate;
        this.imageUrl = imageUrl;
    }

    public Game(String name, String imageUrl) {

        this.name = name;

        this.imageUrl = imageUrl;
    }

    public Game(String name, String imageUrl, Integer averageRate) {

        this.name = name;

        this.imageUrl = imageUrl;

        this.averageRate = averageRate;
    }

    public Game() {

    }

    private Long id;


    private String name;


    private Integer averageRate = 0;


    private String imageUrl;


    public static Game fromEntity(GameEntity gameEntity) {

        return new Game(gameEntity.getId(), gameEntity.getName(), gameEntity.getAverageRate(), gameEntity.getImageUrl());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(Integer averageRate) {
        this.averageRate = averageRate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
