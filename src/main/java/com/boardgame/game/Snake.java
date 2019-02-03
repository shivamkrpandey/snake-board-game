package com.boardgame.game;

public class Snake {
    private int start;
    private int end;

    Snake(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static Snake getSnake(int start, int end) {
        return new Snake(start, end);
    }

    public int getEnd() {
        return end;
    }
}
