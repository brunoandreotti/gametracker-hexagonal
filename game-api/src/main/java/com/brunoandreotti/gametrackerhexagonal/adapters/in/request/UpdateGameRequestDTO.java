package com.brunoandreotti.gametrackerhexagonal.adapters.in.request;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateGameRequestDTO {

    String name;

    String imageUrl;

    Integer averageRate;

    public Game toGameDomain() {
        return new Game(this.name, this.imageUrl, this.averageRate);
    }
}
