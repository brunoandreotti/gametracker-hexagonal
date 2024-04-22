package com.brunoandreotti.gametrackerhexagonal.core.usecase;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import com.brunoandreotti.gametrackerhexagonal.core.exception.GameNotFoundException;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.game.FindGamePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.out.game.SaveGamePort;
import com.brunoandreotti.gametrackerhexagonal.core.usecase.game.UpdateGameUseCase;
import com.brunoandreotti.gametrackerhexagonal.factory.GameTestFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import java.util.Optional;
import java.util.Random;

@ExtendWith(MockitoExtension.class)
public class UpdateGameUseCaseTest {

    @Mock
    public FindGamePort findGamePort;

    @Mock
    public SaveGamePort saveGamePort;

    @InjectMocks
    private UpdateGameUseCase updateGameUseCase;

    @BeforeEach
    void setup() {
        updateGameUseCase = new UpdateGameUseCase(findGamePort, saveGamePort);
    }

    @Test
    void should_updateGame_returnGame() {
        Game game = GameTestFactory.createGame();
        game.setId(new Random().nextLong());

        Game updateGameInfo = GameTestFactory.createGame();



        Mockito.when(findGamePort.findGameById(game.getId())).thenReturn(Optional.of(game));

        BeanUtils.copyProperties(updateGameInfo, game, "id");

        Mockito.when(saveGamePort.saveGame(game)).thenReturn(game);

        Game result = updateGameUseCase.updateById(updateGameInfo, game.getId());

        Assertions.assertThat(result).isEqualTo(game);
        Assertions.assertThat(updateGameInfo.getName()).isEqualTo(result.getName());

    }

    @Test
    void shouldNot_updateNonExistingGame_returnException() {

        Game game = GameTestFactory.createGame();
        game.setId(new Random().nextLong());

        Game updateGameInfo = GameTestFactory.createGame();

        Mockito.when(findGamePort.findGameById(game.getId())).thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> updateGameUseCase.updateById(updateGameInfo, game.getId())).isInstanceOf(GameNotFoundException.class);
    }
}
