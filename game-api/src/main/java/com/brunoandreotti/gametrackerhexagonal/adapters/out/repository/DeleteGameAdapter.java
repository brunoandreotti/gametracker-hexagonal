package com.brunoandreotti.gametrackerhexagonal.adapters.out.repository;

import com.brunoandreotti.gametrackerhexagonal.core.ports.out.game.DeleteGamePort;
import org.springframework.stereotype.Component;

@Component
public class DeleteGameAdapter implements DeleteGamePort {

    private final GameRepository gameRepository;

    public DeleteGameAdapter(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    @Override
    public void deleteGameById(Long id) {
        gameRepository.deleteById(id);
    }
}
