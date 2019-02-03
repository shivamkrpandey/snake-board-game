package com.boardgame.builder;

import com.boardgame.exception.InvalidGameSelected;
import com.boardgame.game.Game;
import com.boardgame.game.SnakeLadderBoard;

public class GameBuilder {
    public static Game getGameBoard(GameType type) throws InvalidGameSelected {
        switch (type) {
            case SNAKE_BOARD:
                return new SnakeLadderBoard();
            default:
                throw new InvalidGameSelected("Selected game is not available to create.");
        }
    }
}
