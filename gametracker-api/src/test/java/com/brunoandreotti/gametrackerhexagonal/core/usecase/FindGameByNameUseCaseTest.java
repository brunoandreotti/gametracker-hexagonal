package com.brunoandreotti.gametrackerhexagonal.core.usecase;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.brunoandreotti.gametrackerhexagonal.core.exception.GameNotFoundException;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.FindGamePort;
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
class FindGameByNameUseCaseTest {

    @Mock
    private FindGamePort findGamePort;

    @InjectMocks
    private FindGameByNameUseCase findGameByNameUseCase;

    @BeforeEach
    void setUp() {
        findGameByNameUseCase = new FindGameByNameUseCase(findGamePort);
    }

    @Test
    void should_FindGameByName_ReturnGame() {
        Game game = GameTestFactory.createGame();
        game.setId(new Random().nextLong());

        Mockito.when(findGamePort.findGameByName(game.getName())).thenReturn(Optional.of(game));

        Game result = findGameByNameUseCase.findByName(game.getName());

        Assertions.assertThat(result).isEqualTo(game);
    }

    @Test
    void shouldNot_FindGameByNonExistingName_ReturnException() {
        Game game = GameTestFactory.createGame();
        game.setId(new Random().nextLong());

        Mockito.when(findGamePort.findGameByName(game.getName())).thenReturn(Optional.empty());


        String gameName = game.getName();
        Assertions.assertThatThrownBy(() -> findGameByNameUseCase.findByName(gameName))
                .isInstanceOf(GameNotFoundException.class)
                .hasMessage("Game not found");
    }


}
