package com.boardgame.game;

import com.boardgame.exception.InvalidMoveException;

interface Rule {
    boolean validate(int move) throws InvalidMoveException;
}
