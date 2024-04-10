package com.brunoandreotti.gametrackerhexagonal.factory;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.github.javafaker.Faker;

import java.util.List;

public class GameTestFactory {

    private static final Faker faker = new Faker();

    public static Game createGame() {
        return new Game(
                faker.animal().name(),
                String.format("https://%s.com", faker.animal().name())
        );
    }

    public static List<Game> createGameList() {
        return List.of(createGame(), createGame(), createGame());

    }
}
