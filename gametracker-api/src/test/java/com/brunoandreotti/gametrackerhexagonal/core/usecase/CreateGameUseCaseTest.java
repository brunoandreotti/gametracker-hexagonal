package com.brunoandreotti.gametrackerhexagonal.core.usecase;



import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;

import com.brunoandreotti.gametrackerhexagonal.core.ports.out.FindGamePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.SaveGamePort;
import com.brunoandreotti.gametrackerhexagonal.factory.GameTestFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Random;



@ExtendWith(MockitoExtension.class)
class CreateGameUseCaseTest {

    @Mock
    private SaveGamePort saveGameAdapter;

    @Mock
    private FindGamePort findGameAdapter;

    @InjectMocks
    private CreateGameUseCase createGameUseCase;

    @BeforeEach
    void setUp() {
        createGameUseCase = new CreateGameUseCase(saveGameAdapter, findGameAdapter);
    }


    @Test
    void should_createGame_WithValidData_ReturnGame() {
        Game game = GameTestFactory.createGame();
        Game gameWithId = new Game(game.getName(), game.getImageUrl());
        gameWithId.setId(new Random().nextLong());


        Mockito.when(findGameAdapter.findGameByName(game.getName())).thenReturn(Optional.empty());
        Mockito.when(saveGameAdapter.saveGame(game)).thenReturn(gameWithId);

        Game result = createGameUseCase.create(game);

        Assertions.assertThat(result).isEqualTo(gameWithId);


    }

    @Test
    void shouldNot_createGame_WithExistingGame_ReturnException() {
        Game game = GameTestFactory.createGame();
        Game gameWithId = new Game(game.getName(), game.getImageUrl());
        gameWithId.setId(new Random().nextLong());

        Mockito.when(findGameAdapter.findGameByName(game.getName())).thenReturn(Optional.of(gameWithId));

        Assertions.assertThatThrownBy(() -> createGameUseCase.create(game))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Game already exists");

    }
}
