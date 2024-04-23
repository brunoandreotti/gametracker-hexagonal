package com.brunoandreotti.gametrackerhexagonal.core.usecase;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.brunoandreotti.gametrackerhexagonal.core.exception.GameNotFoundException;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.game.DeleteGamePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.game.FindGamePort;
import com.brunoandreotti.gametrackerhexagonal.core.usecase.game.DeleteGameUseCase;
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
class DeleteGameUseCaseTest {

    @Mock
    private  FindGamePort findGamePort;

    @Mock
    private  DeleteGamePort deleteGamePort;

    @InjectMocks
    private DeleteGameUseCase deleteGameUseCase;

    @BeforeEach
    void setUp() {
        deleteGameUseCase = new DeleteGameUseCase(findGamePort, deleteGamePort);
    }

    @Test
    void should_deleteExistingGame_returnVoid() {

        Game game = GameTestFactory.createGame();
        game.setId(new Random().nextLong());

        Mockito.when(findGamePort.findGameById(game.getId())).thenReturn(Optional.of(game));


        deleteGameUseCase.delete(game.getId());

        Mockito.verify(deleteGamePort, Mockito.times(1)).deleteGameById(game.getId());
    }

    @Test
    void shouldNot_deleteNonExistingGame_returnException() {
        Game game = GameTestFactory.createGame();
        game.setId(new Random().nextLong());

        Mockito.when(findGamePort.findGameById(game.getId())).thenReturn(Optional.empty());


        Assertions.assertThatThrownBy(() -> deleteGameUseCase.delete(game.getId()))
                .isInstanceOf(GameNotFoundException.class)
                .hasMessage("Game not found");


    }
}
