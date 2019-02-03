package com.boardgame.exception;

/**
 * When a move is invalid, like 95 + 6 in snake ladder game, a pawn moves wrong in chess, this
 * exception can be thrown.
 */
public class InvalidMoveException extends Exception {
    private String message;
    public InvalidMoveException(String message) {
        super(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
