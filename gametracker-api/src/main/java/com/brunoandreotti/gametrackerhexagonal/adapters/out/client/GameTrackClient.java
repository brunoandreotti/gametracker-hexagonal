package com.brunoandreotti.gametrackerhexagonal.adapters.out.client;

import com.brunoandreotti.gametrackerhexagonal.adapters.in.request.GameTrackRequestDTO;
import com.brunoandreotti.gametrackerhexagonal.adapters.in.response.GameTrackResponseDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "gametrack-api", url = "${gametrack-api.url}")
public interface GameTrackClient {

    @GetMapping("/gametracks/{id}")
    List<GameTrackResponseDTO> getGameTrackByGameId(@PathVariable Long id);

    @PostMapping("/gametracks")
    GameTrackResponseDTO createGameTrack(@RequestBody GameTrackRequestDTO gameTrackRequestDTO);

    @DeleteMapping("/gametracks/{id}")
    void deleteGameTrackById(@PathVariable Long id);
}
