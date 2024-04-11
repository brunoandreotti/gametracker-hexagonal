package com.brunoandreotti.gametrackapi.config;

import com.brunoandreotti.gametrackapi.adapters.out.repository.DeleteGameTrackAdapter;
import com.brunoandreotti.gametrackapi.adapters.out.repository.FindGameTrackAdapter;
import com.brunoandreotti.gametrackapi.adapters.out.repository.SaveGameTrackAdapter;
import com.brunoandreotti.gametrackapi.core.ports.in.CreateGameTrackUseCasePort;
import com.brunoandreotti.gametrackapi.core.ports.in.DeleteGameTrackByIdUseCasePort;
import com.brunoandreotti.gametrackapi.core.ports.in.FindGameTrackByGameIdUseCasePort;

import com.brunoandreotti.gametrackapi.core.usecase.CreateGameTrackUseCase;
import com.brunoandreotti.gametrackapi.core.usecase.DeleteGameTrackByIdUseCase;
import com.brunoandreotti.gametrackapi.core.usecase.FindGameTrackByGameIdUseCase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CreateGameTrackUseCasePort createGameTrackUseCase(SaveGameTrackAdapter saveGameTrackAdapter) {
        return new CreateGameTrackUseCase(saveGameTrackAdapter);
    }

    @Bean
    public FindGameTrackByGameIdUseCasePort findGameTrackByGameIdUseCase(FindGameTrackAdapter findGameTrackAdapter) {
        return new FindGameTrackByGameIdUseCase(findGameTrackAdapter);
    }

    @Bean
    public DeleteGameTrackByIdUseCasePort deleteGameTrackByIdUseCase(DeleteGameTrackAdapter deleteGameTrackAdapter, FindGameTrackAdapter findGameTrackPort) {
        return new DeleteGameTrackByIdUseCase(deleteGameTrackAdapter, findGameTrackPort);
    }
}
