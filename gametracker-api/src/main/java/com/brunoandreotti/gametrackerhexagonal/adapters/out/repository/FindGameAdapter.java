package com.brunoandreotti.gametrackerhexagonal.adapters.out.repository;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.FindGamePort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class FindGameAdapter implements FindGamePort {

    private final GameRepository gameRepository;

    public FindGameAdapter(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Optional<Game> findGameByName(String name) {
        Optional<GameEntity> game = gameRepository.findByName(name);

        return game.map(Game::fromEntity);


    }

    @Override
    public Optional<Game> findGameById(Long id) {
        return gameRepository.findById(id).map(Game::fromEntity);
    }

    @Override
    public List<Game> findAllGames() {
        return gameRepository.findAll().stream().map(Game::fromEntity).toList();
    }
}
