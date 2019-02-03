package com.boardgame.game;

/**
 * It represents boxes in the game of {@link SnakeLadderBoard} game.
 */
public class Box {
    private int position;
    private Snake snake;
    private Ladder ladder;

    public Box(int position, Snake snake, Ladder ladder) {
        this.position = position;
        this.snake = snake;
        this.ladder = ladder;
    }

    public int getPosition() {
        return position;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Snake getSnake() {
        return snake;
    }
}
