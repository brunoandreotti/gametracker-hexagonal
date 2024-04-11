package com.brunoandreotti.gametrackapi.core.exception;

public class GameTrackNotFoundException extends RuntimeException {
    public GameTrackNotFoundException(final String message) {
        super(message);
    }
}
