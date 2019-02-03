package com.boardgame.exception;

/**
 * This exception is thrown when selects wrong game to create which is not available.
 */
public class InvalidGameSelected extends Exception {
    private String message;
    public InvalidGameSelected(String message) {
        super(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
