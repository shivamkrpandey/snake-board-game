package com.boardgame.game;

import com.boardgame.exception.GameEndException;
import com.boardgame.exception.InvalidMoveException;

/**
 * It gives capability to {@link Player} for moving on the {@link Game}.
 */
interface Movable {
    void move(int moveBy) throws GameEndException, InvalidMoveException;
}
