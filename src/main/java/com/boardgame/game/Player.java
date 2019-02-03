package com.boardgame.game;

import com.boardgame.exception.GameEndException;
import com.boardgame.exception.InvalidMoveException;

public class Player implements Movable {
    private int playerId;
    private int playerFirstTurn;
    private Box currentBox;
    private Game game;

    public Player(int playerId, Game game, Integer playerFirstTurn) {
        this.playerId = playerId;
        this.game = game;
        this.currentBox = new Box(0, null, null);
        this.playerFirstTurn = playerFirstTurn;
    }

    public void setPlayerFirstTurn(int playerFirstTurn) {
        this.playerFirstTurn = playerFirstTurn;
    }

    public int getPlayerFirstTurn() {
        return playerFirstTurn;
    }

    @Override
    public void move(int moveBy) throws GameEndException, InvalidMoveException {
        if (this.game.hasWinnerDeclared()) {
            throw new GameEndException("Game ended. Winner declared.");
        }

        this.game.validate(moveBy);

        Integer pos = this.currentBox.getPosition() + moveBy;

        if (pos > 100) {
            throw new InvalidMoveException(pos + " This move cannot be made. Please try again to reach 100");
        }

        this.currentBox = this.game.getBoxById(pos);

        if (this.currentBox.getLadder() != null) {
            setCurrentBox(this.currentBox = this.game.getBoxById(this.currentBox.getLadder().getEnd()));
        }

        if (this.currentBox.getSnake() != null) {
            setCurrentBox(this.game.getBoxById(this.currentBox.getSnake().getEnd()));
        }

        if (pos == 100) {
            System.out.println("Player " + this.playerId + " has won.");

            this.game.setWinnerDeclared(true);

            throw new GameEndException("Player " + this.playerId + " has won.");
        }
    }

    private void setCurrentBox(Box currentBox) {
        this.currentBox = currentBox;
    }

    public int getPlayerId() {
        return this.playerId;
    }

    public int getCurrentPosition() {
        return this.currentBox.getPosition();
    }
}
