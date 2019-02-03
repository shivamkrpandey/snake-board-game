package com.boardgame.game;

/**
 * This interface is added to achieve the abstraction for the type of game that can be played. We can place the
 * snake-ladder game with chess or ludo.
 */
public interface Game extends Rule {
    /**
     * For each game, there is a winner and game should stop when winner declared or we can use this method
     * to declare 2nd and 3rd.
     *
     * @return {@link boolean} status
     */
    boolean hasWinnerDeclared();

    /**
     * This method sets the winner in the implementing class.
     *
     * @param status {@link boolean} status being set.
     */
    void setWinnerDeclared(boolean status);

    /**
     * For the board based games, we can use this method to move the players box.
     * @param move {@link int}
     * @return {@link Box}
     */
    Box getBoxById(int move);
}