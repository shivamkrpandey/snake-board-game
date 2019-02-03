package com.boardgame.game;

import com.boardgame.exception.InvalidMoveException;

/**
 * This is a marker interface for Games only.
 */
public interface Game {
    boolean hasWinnerDeclared();
    void setWinnerDeclared(boolean status);

    Box getBoxById(int move);

    boolean validate(int moveBy) throws InvalidMoveException;
}