package com.brunoandreotti.gametrackapi.adapters.out.repository;

import com.brunoandreotti.gametrackapi.core.domain.GameTrack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameTrackRepository extends JpaRepository<GameTrackEntity, Long> {

    List<GameTrackEntity> findByGameId(Long gameId);
}
