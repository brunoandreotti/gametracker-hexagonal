package com.brunoandreotti.gametrackerhexagonal.adapters.out.client;

import com.brunoandreotti.gametrackerhexagonal.adapters.in.request.GameTrackRequestDTO;
import com.brunoandreotti.gametrackerhexagonal.adapters.in.response.GameTrackResponseDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "gametrack-api", url = "${gametrack-api.url}")
public interface GameTrackClient {


    @GetMapping("/gametracks/{id}")
    @CircuitBreaker(name = "findGameTrackCB", fallbackMethod = "returnStandardResponse")
    List<GameTrackResponseDTO> getGameTrackByGameId(@PathVariable Long id);

    @PostMapping("/gametracks")
    GameTrackResponseDTO createGameTrack(@RequestBody GameTrackRequestDTO gameTrackRequestDTO);

    @DeleteMapping("/gametracks/{id}")
    void deleteGameTrackById(@PathVariable Long id);

    default List<GameTrackResponseDTO> returnStandardResponse(Exception exception) {

        System.out.println("circuit breaker default method");
        return List.of(new GameTrackResponseDTO(999L, 0, 0, 999L));
    }
}
