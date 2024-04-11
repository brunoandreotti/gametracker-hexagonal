package com.brunoandreotti.gametrackerhexagonal.adapters.in.controller;

import com.brunoandreotti.gametrackerhexagonal.adapters.in.controller.response.GameTrackResponseDTO;
import com.brunoandreotti.gametrackerhexagonal.core.domain.GameTrack;
import com.brunoandreotti.gametrackerhexagonal.core.ports.in.gametrack.FindGameTrackByGameIdUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gametracks")
public class GameTrackController {

    private final FindGameTrackByGameIdUseCasePort findGameTrackByGameIdUseCase;

    public GameTrackController(FindGameTrackByGameIdUseCasePort findGameTrackByGameIdUseCase) {
        this.findGameTrackByGameIdUseCase = findGameTrackByGameIdUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<GameTrackResponseDTO>> findGameTrackByGameId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(findGameTrackByGameIdUseCase.find(id).stream().map(GameTrackResponseDTO::fromGameDomain).toList());
    }
}
