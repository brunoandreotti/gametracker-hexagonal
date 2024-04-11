package com.brunoandreotti.gametrackerhexagonal.adapters.out.client;

import com.brunoandreotti.gametrackerhexagonal.adapters.in.controller.response.GameTrackResponseDTO;
import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "gametrack-api", url = "${gametrack-api.url}")
public interface GameTrackClient {

    @GetMapping("/gametracks/{id}")
    List<GameTrackResponseDTO> getGameTrackByGameId(@PathVariable Long id);
}
