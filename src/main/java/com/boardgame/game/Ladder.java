package com.boardgame.game;

public class Ladder {
    private int start;
    private int end;

    private Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static Ladder getLadder(int start, int end) {
        return new Ladder(start, end);
    }

    public int getEnd() {
        return this.end;
    }
}
