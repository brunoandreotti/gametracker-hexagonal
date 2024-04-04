package com.brunoandreotti.gametrackerhexagonal.adapters.out.repository;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.SaveGamePort;

import org.springframework.stereotype.Component;

@Component
public class SaveGameAdapter implements SaveGamePort {

    private final GameRepository gameRepository;

    public SaveGameAdapter(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game saveGame(Game game) {
        GameEntity gameEntity = new GameEntity(game);
        GameEntity savedGame = gameRepository.save(gameEntity);
        game.setId(savedGame.getId());
        return game;
    }
}
