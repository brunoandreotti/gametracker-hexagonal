package com.brunoandreotti.gametrackerhexagonal.adapters.in.controller;

import com.brunoandreotti.gametrackerhexagonal.adapters.in.request.GameRequestDTO;
import com.brunoandreotti.gametrackerhexagonal.adapters.in.request.UpdateGameRequestDTO;
import com.brunoandreotti.gametrackerhexagonal.adapters.in.response.GameResponseDTO;

import com.brunoandreotti.gametrackerhexagonal.adapters.in.response.GameTrackResponseDTO;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.game.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final CreateGameUseCasePort createGameUseCase;

    private final FindAllGamesUseCasePort findAllGamesUseCase;

    private final FindGameByNameUseCasePort findGameByNameUseCase;

    private final DeleteGameUseCasePort deleteGameUseCase;

    private final UpdateGameUseCasePort updateGameUseCase;


    public GameController(CreateGameUseCasePort createGameUseCase, FindAllGamesUseCasePort findAllGamesUseCase, FindGameByNameUseCasePort findGameByNameUseCase, DeleteGameUseCasePort deleteGameUseCase, UpdateGameUseCasePort updateGameUseCase) {
        this.createGameUseCase = createGameUseCase;
        this.findAllGamesUseCase = findAllGamesUseCase;
        this.findGameByNameUseCase = findGameByNameUseCase;
        this.deleteGameUseCase = deleteGameUseCase;
        this.updateGameUseCase = updateGameUseCase;
    }

    @PostMapping()
    public ResponseEntity<GameResponseDTO> createGame(@RequestBody GameRequestDTO gameRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(GameResponseDTO.fromGameDomain(createGameUseCase.create(gameRequest.toGameDomain())));
    }

    @GetMapping()
    public ResponseEntity<List<GameResponseDTO>> findAllGames() {
        return ResponseEntity.status(HttpStatus.OK).body(findAllGamesUseCase.findAll().stream().map(GameResponseDTO::fromGameDomain).toList());
    }

    @GetMapping("/{name}")
    public ResponseEntity<GameResponseDTO> findGameByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(GameResponseDTO.fromGameDomain(findGameByNameUseCase.findByName(name)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        deleteGameUseCase.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameResponseDTO> updateGameById(@PathVariable Long id, @RequestBody UpdateGameRequestDTO gameRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(GameResponseDTO.fromGameDomain(updateGameUseCase.updateById(gameRequest.toGameDomain(), id)));
    }

    @GetMapping("/isAlive")
    public ResponseEntity<String> checkIsAlive() {
        return ResponseEntity.status(HttpStatus.OK).body("Is Alive!!!");
    }
}
