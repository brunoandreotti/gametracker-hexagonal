package com.brunoandreotti.gametrackerhexagonal.config;

import com.brunoandreotti.gametrackerhexagonal.adapters.out.client.FindGameTrackAdapter;
import com.brunoandreotti.gametrackerhexagonal.adapters.out.repository.FindGameAdapter;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.gametrack.FindGameTrackByGameIdUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.game.FindGamePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.gametrack.FindGameTrackPort;
import com.brunoandreotti.gametrackerhexagonal.core.usecase.gametrack.FindGameTrackByGameIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameTrackBeanConfig {

    @Bean
    public FindGameTrackByGameIdUseCasePort findGameTrackByGameIdUseCase(FindGameAdapter findGameAdapter, FindGameTrackAdapter findGameTrackAdapter){
        return new FindGameTrackByGameIdUseCase(findGameAdapter, findGameTrackAdapter);
    }
}
