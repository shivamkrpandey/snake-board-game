package com.boardgame.controller;

import java.util.List;

public class CustomResponse {
    private int total;
    private List<List<Integer>> moves;
    private String winner;
    private String errorMessage;
    private List<String> playersPosition;

    CustomResponse() {

    }

    public List<String> getPlayersPosition() {
        return playersPosition;
    }

    public void setPlayersPosition(List<String> playersPosition) {
        this.playersPosition = playersPosition;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public List<List<Integer>> getMoves() {
        return moves;
    }

    public void setMoves(List<List<Integer>> moves) {
        this.moves = moves;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
