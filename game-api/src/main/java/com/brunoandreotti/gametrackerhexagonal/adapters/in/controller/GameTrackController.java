package com.brunoandreotti.gametrackerhexagonal.adapters.in.controller;

import com.brunoandreotti.gametrackerhexagonal.adapters.in.request.GameTrackRequestDTO;
import com.brunoandreotti.gametrackerhexagonal.adapters.in.response.GameTrackResponseDTO;

import com.brunoandreotti.gametrackerhexagonal.core.ports.in.gametrack.CreateGameTrackUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.gametrack.DeleteGameTrackUseCasePort;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.gametrack.FindGameTrackByGameIdUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gametracks")
public class GameTrackController {

    private final FindGameTrackByGameIdUseCasePort findGameTrackByGameIdUseCase;

    private final CreateGameTrackUseCasePort createGameTrackUseCase;

    private final DeleteGameTrackUseCasePort deleteGameTrackUseCase;

    public GameTrackController(FindGameTrackByGameIdUseCasePort findGameTrackByGameIdUseCase, CreateGameTrackUseCasePort createGameTrackUseCase, DeleteGameTrackUseCasePort deleteGameTrackUseCase) {
        this.findGameTrackByGameIdUseCase = findGameTrackByGameIdUseCase;
        this.createGameTrackUseCase = createGameTrackUseCase;
        this.deleteGameTrackUseCase = deleteGameTrackUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<GameTrackResponseDTO>> findGameTrackByGameId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(findGameTrackByGameIdUseCase.find(id).stream().map(GameTrackResponseDTO::fromGameDomain).toList());
    }

    @PostMapping
    public ResponseEntity<GameTrackResponseDTO> createGameTrack(@RequestBody GameTrackRequestDTO gameTrackRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(GameTrackResponseDTO.fromGameDomain(createGameTrackUseCase.create(gameTrackRequestDTO.toGameTrackDomain())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGameTrack(@PathVariable Long id) {
        deleteGameTrackUseCase.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
