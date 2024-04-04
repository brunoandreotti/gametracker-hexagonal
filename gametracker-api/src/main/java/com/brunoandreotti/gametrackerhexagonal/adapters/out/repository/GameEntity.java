package com.brunoandreotti.gametrackerhexagonal.adapters.out.repository;

import com.brunoandreotti.gametrackerhexagonal.core.domain.Game;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_game")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer averageRate = 0;

    @Column
    private String imageUrl;

    public GameEntity(Game game) {
        this.name = game.getName();
        this.averageRate = getAverageRate();
        this.imageUrl = game.getImageUrl();
    }
}
