package com.boardgame.controller;

import java.util.List;

/**
 * This class represents the request json format.
 */
public class CustomRequest {
    private Integer n;
    private List<List<Integer>> firstNMoves;
    private List<List<Integer>> playersMove;
    CustomRequest(int n, List<List<Integer>> firstNMoves) {
        this.n = n;
        this.firstNMoves = firstNMoves;
    }

    public CustomRequest(int n, List<List<Integer>> firstNMoves, List<List<Integer>> playersMove) {
        this.n = n;
        this.firstNMoves = firstNMoves;
        this.playersMove = playersMove;
    }

    CustomRequest() {

    }

    public int getN() {
        return n;
    }

    public List<List<Integer>> getFirstNMoves() {
        return firstNMoves;
    }

    public List<List<Integer>> getPlayersMove() {
        return playersMove;
    }

    public void setFirstNMoves(List<List<Integer>> firstNMoves) {
        this.firstNMoves = firstNMoves;
    }

    public void setPlayersMove(List<List<Integer>> playersMove) {
        this.playersMove = playersMove;
    }

    public void setN(int n) {
        this.n = n;
    }

    public boolean validateRequest() {
        checkArgument(this.n < 2 || this.n > 6, "This game cannot be played with less than 2 and max 6 players.");
        checkArgument(this.firstNMoves.size() != this.n, "Please provide first turn of all the players");

        checkArgument(this.playersMove != null && this.playersMove.size() == 0, "Please provide moves of each player.");

        if (this.playersMove != null) {
            for (int index = 0; index < this.playersMove.size(); index++) {
                checkArgument(this.playersMove.get(index).size() != 2, "The input set for moves can contain two " +
                        "length input of numbers only.");
            }
        }

        return true;
    }

    private boolean checkArgument(boolean conditionStatus, String exceptionMessage) {
        if (conditionStatus) {
            throw new IllegalArgumentException(exceptionMessage);
        }

        return true;
    }
}
