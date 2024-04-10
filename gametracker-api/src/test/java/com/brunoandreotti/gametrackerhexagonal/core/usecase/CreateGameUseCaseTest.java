package com.brunoandreotti.gametrackerhexagonal.core.usecase;



import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;

import com.brunoandreotti.gametrackerhexagonal.core.exception.GameAlreadyExistsException;

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
    private SaveGamePort saveGamePort;

    @Mock
    private FindGamePort findGamePort;

    @InjectMocks
    private CreateGameUseCase createGameUseCase;

    @BeforeEach
    void setUp() {
        createGameUseCase = new CreateGameUseCase(saveGamePort, findGamePort);
    }


    @Test
    void should_createGame_WithValidData_ReturnGame() {
        //Arrange
        Game game = GameTestFactory.createGame();
        Game gameWithId = new Game(game.getName(), game.getImageUrl());
        gameWithId.setId(new Random().nextLong());

        Mockito.when(findGamePort.findGameByName(game.getName())).thenReturn(Optional.empty());
        Mockito.when(saveGamePort.saveGame(game)).thenReturn(gameWithId);

        //Act
        Game result = createGameUseCase.create(game);

        //Assert
        Assertions.assertThat(result).isEqualTo(gameWithId);


    }

    @Test
    void shouldNot_createGame_WithExistingGame_ReturnException() {
        Game game = GameTestFactory.createGame();
        Game gameWithId = new Game(game.getName(), game.getImageUrl());
        gameWithId.setId(new Random().nextLong());

        Mockito.when(findGamePort.findGameByName(game.getName())).thenReturn(Optional.of(gameWithId));

        Assertions.assertThatThrownBy(() -> createGameUseCase.create(game))
                .isInstanceOf(GameAlreadyExistsException.class)
                .hasMessage("Game already exists");

    }
}
