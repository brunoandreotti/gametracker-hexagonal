package com.brunoandreotti.gametrackerhexagonal.adapters.in.controller.request;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameTrackRequestDTO {

    private Integer hoursPlayed;

    private Integer rate;

    private Long gameId;


}
