package com.boardgame.util;

import com.boardgame.game.Ladder;
import com.boardgame.game.Snake;

import com.boardgame.game.Box;

import java.util.HashMap;

/**
 * This is a utility, used as a resource to create the game based on the given snake and ladder positions.
 */
public class BoardBluePrint {

    public static HashMap<Integer, Box> getGameBoard() {
        HashMap<Integer, Box> gameBoard = new HashMap<>();

        gameBoard.put(5, new Box(5, null, Ladder.getLadder(5, 25)));
        gameBoard.put(10, new Box(10, null, Ladder.getLadder(10, 29)));
        gameBoard.put(22, new Box(22, null, Ladder.getLadder(22, 41)));
        gameBoard.put(28, new Box(28, null, Ladder.getLadder(28, 55)));
        gameBoard.put(31, new Box(31, Snake.getSnake(31, 14), null));
        gameBoard.put(37, new Box(37, Snake.getSnake(37, 17), null));
        gameBoard.put(44, new Box(44, null, Ladder.getLadder(44, 95)));
        gameBoard.put(70, new Box(70, null, Ladder.getLadder(70, 89)));
        gameBoard.put(73, new Box(73, Snake.getSnake(73, 53), null));
        gameBoard.put(78, new Box(78, Snake.getSnake(78, 39), null));
        gameBoard.put(79, new Box(79, null, Ladder.getLadder(79, 81)));
        gameBoard.put(91, new Box(91, Snake.getSnake(92, 35), null));
        gameBoard.put(99, new Box(99, Snake.getSnake(99, 7), null));

        return gameBoard;
    }
}
