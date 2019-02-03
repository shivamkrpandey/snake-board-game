package com.boardgame.game;

import com.boardgame.exception.GameEndException;
import com.boardgame.exception.InvalidMoveException;

interface Movable {
    void move(int moveBy) throws GameEndException, InvalidMoveException;
}
