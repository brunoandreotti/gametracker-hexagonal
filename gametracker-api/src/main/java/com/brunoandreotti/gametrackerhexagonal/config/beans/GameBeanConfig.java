package com.brunoandreotti.gametrackerhexagonal.config.beans;

import com.brunoandreotti.gametrackerhexagonal.adapters.out.repository.DeleteGameAdapter;
import com.brunoandreotti.gametrackerhexagonal.adapters.out.repository.FindGameAdapter;
import com.brunoandreotti.gametrackerhexagonal.adapters.out.repository.SaveGameAdapter;

import com.brunoandreotti.gametrackerhexagonal.core.ports.in.game.*;
import com.brunoandreotti.gametrackerhexagonal.core.usecase.game.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameBeanConfig {

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

    @Bean
    public UpdateGameUseCasePort updateGameUseCasePort (FindGameAdapter findGameAdapter, SaveGameAdapter saveGameAdapter) {
        return new UpdateGameUseCase(findGameAdapter, saveGameAdapter);
    }


}
