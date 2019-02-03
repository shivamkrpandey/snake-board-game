package com.boardgame.game;

import com.boardgame.exception.InvalidMoveException;
import com.boardgame.util.BoardBluePrint;

import javax.inject.Singleton;
import java.util.HashMap;

/**
 * SnakeLadder game which is a {@link BoardBasedGame} and need to implement the methods of interface.
 */
@Singleton
public class SnakeLadderBoard implements BoardBasedGame, Rule {
    private final static String GAME_NAME = "Snake-Ladder Game";

    // Winner declare and avoid further moves.
    private boolean hasDeclaredWinner = false;

    private HashMap<Integer, Box> board = new HashMap<>(100);

    public SnakeLadderBoard() {
        prepareGameBoard();
    }

    @Override
    public boolean hasWinnerDeclared() {
        return hasDeclaredWinner;
    }

    @Override
    public void setWinnerDeclared(boolean status) {
        this.hasDeclaredWinner = status;
    }

    // Player cannot move more than 6 step.
    @Override
    public boolean validate(int move) throws InvalidMoveException {
        if (move <= 6 && move > 0) {
            return true;
        }

        throw new InvalidMoveException(move + " is not a valid move on " + GAME_NAME + " board.");
    }

    /**
     * This method prepares the SnakeLadder Board to be played the {@link Player}.
     */
    @Override
    public void prepareGameBoard() {
        HashMap<Integer, Box> gameBoard = new HashMap<>(100);

        HashMap<Integer, Box> boxes = BoardBluePrint.getGameBoard();

        for(int boardIndex = 1; boardIndex <= 100; boardIndex++) {
            if (boxes.containsKey(boardIndex)) {
                gameBoard.put(boardIndex, boxes.get(boardIndex));
            } else {
                gameBoard.put(boardIndex, new Box(boardIndex, null, null));
            }
        }

        setBoard(gameBoard);
    }

    public static String getGameName() {
        return GAME_NAME;
    }

    public void setBoard(HashMap<Integer, Box> board) {
        this.board = board;
    }

    /**
     * Based on the move, it returns the current box to set for the {@link com.boardgame.game.Player}
     * @param id
     * @return
     */
    @Override
    public Box getBoxById(int id) {
        return this.board.get(id);
    }
}
