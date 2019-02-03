package com.boardgame.game;

/**
 * Each game based games should implement this interface.
 */
interface BoardBasedGame extends Game {
    /**
     * This method prepares the game game to play.
     */
    void prepareGameBoard();
}
