package com.brunoandreotti.gametrackerhexagonal.config.beans;

import com.brunoandreotti.gametrackerhexagonal.adapters.out.client.CreateGameTrackAdapter;
import com.brunoandreotti.gametrackerhexagonal.adapters.out.client.DeleteGameTrackAdapter;
import com.brunoandreotti.gametrackerhexagonal.adapters.out.client.FindGameTrackAdapter;
import com.brunoandreotti.gametrackerhexagonal.adapters.out.repository.FindGameAdapter;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.gametrack.CreateGameTrackUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.gametrack.DeleteGameTrackUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.gametrack.FindGameTrackByGameIdUseCasePort;

import com.brunoandreotti.gametrackerhexagonal.core.usecase.gametrack.CreateGameTrackUseCase;
import com.brunoandreotti.gametrackerhexagonal.core.usecase.gametrack.DeleteGameTrackUseCase;
import com.brunoandreotti.gametrackerhexagonal.core.usecase.gametrack.FindGameTrackByGameIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameTrackBeanConfig {

    @Bean
    public FindGameTrackByGameIdUseCasePort findGameTrackByGameIdUseCase(FindGameAdapter findGameAdapter, FindGameTrackAdapter findGameTrackAdapter){
        return new FindGameTrackByGameIdUseCase(findGameAdapter, findGameTrackAdapter);
    }

    @Bean
    public CreateGameTrackUseCasePort createGameTrackUseCase(FindGameAdapter findGameAdapter, CreateGameTrackAdapter createGameTrackAdapter){
        return new CreateGameTrackUseCase(findGameAdapter, createGameTrackAdapter);
    }

    @Bean
    public DeleteGameTrackUseCasePort deleteGameTrackUseCasePort(DeleteGameTrackAdapter deleteGameTrackAdapter) {
        return new DeleteGameTrackUseCase(deleteGameTrackAdapter);
    }
}
