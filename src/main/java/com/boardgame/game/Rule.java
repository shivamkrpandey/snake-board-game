package com.boardgame.game;

import com.boardgame.exception.InvalidMoveException;

/**
 * Each {@link Game} must have some rules which should be validated before move or declaring winner.
 */
interface Rule {
    /**
     * Validate the players move {@link Integer}. Example: For dice.
     * @param moveBy {@link int}
     * @return {@link Boolean}
     * @throws InvalidMoveException - When move is not allowed by the {@link Game} or rule.
     */
    boolean validate(int moveBy) throws InvalidMoveException;
}
