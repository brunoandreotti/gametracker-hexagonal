package com.brunoandreotti.gametrackerhexagonal.core.usecase;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.game.FindGamePort;
import com.brunoandreotti.gametrackerhexagonal.core.usecase.game.FindAllGamesUseCase;
import com.brunoandreotti.gametrackerhexagonal.factory.GameTestFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class FindAllGamesUseCaseTest {

    @Mock
    private FindGamePort findGamePort;

    @InjectMocks
    private FindAllGamesUseCase findAllGamesUseCase;

    @BeforeEach
    void setup() {
        findAllGamesUseCase = new FindAllGamesUseCase(findGamePort);
    }

    @Test
    void should_FindAllGames_ReturnGameList() {
        List<Game> gameList = GameTestFactory.createGameList();

        Mockito.when(findGamePort.findAllGames()).thenReturn(gameList);

        List<Game> result = findAllGamesUseCase.findAll();

        Assertions.assertThat(result).isEqualTo(gameList);
    }
}
