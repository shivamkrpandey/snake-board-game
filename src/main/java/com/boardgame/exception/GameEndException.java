package com.boardgame.exception;

/**
 * This exception is thrown when a player won the match.
 */
public class GameEndException extends Exception {
    private String message;
    public GameEndException(String message) {
        super(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
