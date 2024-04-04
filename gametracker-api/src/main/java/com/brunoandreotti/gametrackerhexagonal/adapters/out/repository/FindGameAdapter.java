package com.brunoandreotti.gametrackerhexagonal.adapters.out.repository;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.FindGamePort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class FindGameAdapter implements FindGamePort {

    private final GameRepository gameRepository;

    public FindGameAdapter(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game findGameByName(String name) {
        GameEntity game = gameRepository.findByName(name);

       return game == null ? null : Game.fromEntity(game);


    }

    @Override
    public List<Game> findAllGames() {
        return gameRepository.findAll().stream().map(Game::fromEntity).toList();
    }
}
