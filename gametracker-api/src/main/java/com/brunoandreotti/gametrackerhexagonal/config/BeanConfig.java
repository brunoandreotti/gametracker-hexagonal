package com.brunoandreotti.gametrackerhexagonal.config;

import com.brunoandreotti.gametrackerhexagonal.adapters.out.repository.DeleteGameAdapter;
import com.brunoandreotti.gametrackerhexagonal.adapters.out.repository.FindGameAdapter;
import com.brunoandreotti.gametrackerhexagonal.adapters.out.repository.SaveGameAdapter;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.CreateGameUseCasePort;

import com.brunoandreotti.gametrackerhexagonal.core.ports.in.DeleteGameUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.FindAllGamesUseCasePort;

import com.brunoandreotti.gametrackerhexagonal.core.ports.in.FindGameByNameUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.usecase.CreateGameUseCase;
import com.brunoandreotti.gametrackerhexagonal.core.usecase.DeleteGameUseCase;
import com.brunoandreotti.gametrackerhexagonal.core.usecase.FindAllGamesUseCase;
import com.brunoandreotti.gametrackerhexagonal.core.usecase.FindGameByNameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    //Informa qual o Adapter que será utilizado no use case, uma vez que ele depende da interface e não da implementação
    //é necessário informar qual implementação será utilizada
    @Bean
    public CreateGameUseCasePort createGameUseCase (SaveGameAdapter saveGameAdapter, FindGameAdapter findGameAdapter) {
        return new CreateGameUseCase(saveGameAdapter, findGameAdapter);
    }

    @Bean
    public FindAllGamesUseCasePort findAllGamesUseCase (FindGameAdapter findGameAdapter) {
        return new FindAllGamesUseCase(findGameAdapter);
    }

    @Bean
    public FindGameByNameUseCasePort findGameByNameUseCase (FindGameAdapter findGameAdapter) {
        return new FindGameByNameUseCase(findGameAdapter);
    }

    @Bean
    public DeleteGameUseCasePort deleteGameUseCasePort (DeleteGameAdapter deleteGameAdapter, FindGameAdapter findGameAdapter) {
        return new DeleteGameUseCase(findGameAdapter, deleteGameAdapter);
    }


}
