package com.boardgame.game;

/**
 * Each board based games should implement this interface.
 */
interface BoardBasedGame extends Game {
    /**
     * This method prepares the game board to play.
     */
    void prepareGameBoard();
}