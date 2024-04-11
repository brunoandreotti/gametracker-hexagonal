package com.brunoandreotti.gametrackapi.adapters.in.controller;

import com.brunoandreotti.gametrackapi.adapters.in.controller.request.GameTrackRequestDTO;
import com.brunoandreotti.gametrackapi.adapters.in.controller.response.GameTrackResponseDTO;
import com.brunoandreotti.gametrackapi.core.ports.in.CreateGameTrackUseCasePort;
import com.brunoandreotti.gametrackapi.core.ports.in.DeleteGameTrackByIdUseCasePort;
import com.brunoandreotti.gametrackapi.core.ports.in.FindGameTrackByGameIdUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gametracks")
public class GameTrackeController {

    private final CreateGameTrackUseCasePort createGameTrackUseCase;

    private final FindGameTrackByGameIdUseCasePort findGameTrackByGameIdUseCase;

    private final DeleteGameTrackByIdUseCasePort deleteGameTrackByIdUseCase;

    public GameTrackeController(CreateGameTrackUseCasePort createGameTrackUseCase, FindGameTrackByGameIdUseCasePort findGameTrackByGameIdUseCase, DeleteGameTrackByIdUseCasePort deleteGameTrackByIdUseCase) {
        this.createGameTrackUseCase = createGameTrackUseCase;
        this.findGameTrackByGameIdUseCase = findGameTrackByGameIdUseCase;
        this.deleteGameTrackByIdUseCase = deleteGameTrackByIdUseCase;
    }

    @PostMapping
    public ResponseEntity<GameTrackResponseDTO> createGameTrack(@RequestBody GameTrackRequestDTO gameTrackRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(GameTrackResponseDTO.fromGameDomain(createGameTrackUseCase.create(gameTrackRequestDTO.toGameTrackDomain())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<GameTrackResponseDTO>> getGameTrackByGameId(@PathVariable() Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(findGameTrackByGameIdUseCase.find(id).stream().map(GameTrackResponseDTO::fromGameDomain).toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGameTrack(@PathVariable() Long id) {
        deleteGameTrackByIdUseCase.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
