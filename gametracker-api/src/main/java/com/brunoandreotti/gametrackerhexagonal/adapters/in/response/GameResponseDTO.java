package com.brunoandreotti.gametrackerhexagonal.adapters.in.response;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameResponseDTO {

    private Long id;

    private String name;

    private Integer averageRate;

    private String imageUrl;

    public static GameResponseDTO fromGameDomain(Game game) {
        return new GameResponseDTO(game.getId(), game.getName(), game.getAverageRate(), game.getImageUrl());
    }
}
