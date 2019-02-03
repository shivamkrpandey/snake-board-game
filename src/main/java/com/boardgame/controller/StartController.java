package com.boardgame.controller;

import com.boardgame.builder.GameBuilder;
import com.boardgame.builder.GameType;
import com.boardgame.exception.GameEndException;
import com.boardgame.exception.InvalidGameSelected;
import com.boardgame.exception.InvalidMoveException;
import com.boardgame.game.Game;
import com.boardgame.game.Player;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import javax.validation.constraints.Size;
import java.util.*;

@Controller("/")
public class StartController {

    @Post(value = "/play", consumes = MediaType.APPLICATION_JSON)
    CustomResponse play(@Size(max = 1024) @Body CustomRequest request) {
        CustomResponse response = new CustomResponse();
        try {
            request.validateRequest();
        } catch (IllegalArgumentException exception) {
            response.setErrorMessage(exception.getMessage());

            return response;
        }

        response.setTotal(request.getN());

        Game snakeLadderGame;

        try {
            snakeLadderGame = GameBuilder.getGameBoard(GameType.SNAKE_BOARD);
        } catch (InvalidGameSelected exception) {
            response.setErrorMessage(exception.getMessage());

            return response;
        }

        List<List<Integer>> firstNMoves = request.getFirstNMoves();

        // To get the ordered entries of players in the map.
        List<Player> players = new ArrayList<>(request.getN());

        // Create players
        for (int i = 1; i <= request.getN(); i++) {
            players.add(new Player(i, snakeLadderGame, getFirstTurn(firstNMoves, i)));
        }

        players.sort(new Comparator<Player>() {
            @Override
            public int compare(Player playerOne, Player playerTwo) {
                if (playerOne.getPlayerFirstTurn() > playerTwo.getPlayerFirstTurn()) {
                    return -1;
                } else if (playerOne.getPlayerFirstTurn() < playerTwo.getPlayerFirstTurn()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        LinkedHashMap<Integer, Player> playersMap = new LinkedHashMap<>();
        for(int i =0; i< players.size(); i++) {
            playersMap.put(players.get(i).getPlayerId(), players.get(i));
        }

        List<List<Integer>> playersMoves = request.getPlayersMove();

        for (int index = 0; index < playersMoves.size(); index++) {
            List<Integer> playerIdWithMoveBy = playersMoves.get(index);
            System.out.println("List move values: "+ playerIdWithMoveBy);

            Player player = playersMap.get(playerIdWithMoveBy.get(0));
            System.out.println("Player: " + player.getPlayerId());

            if (playerIdWithMoveBy.get(0) == player.getPlayerId()) {
                try {
                    player.move(playerIdWithMoveBy.get(1));
                } catch (GameEndException exception) {
                    response.setErrorMessage(exception.getMessage());

                    return response;
                } catch (InvalidMoveException exception) {
                    response.setErrorMessage(exception.getMessage());

                    return response;
                }
            }
        }

        response.setPlayersPosition(preparePlayersPositionResult(playersMap, request.getN()));

        return response;
    }

    private static Integer getFirstTurn(List<List<Integer>> firstNMoves, Integer forId) {
        for(int i =0; i < firstNMoves.size(); i++) {
            if (firstNMoves.get(i).get(0).equals(forId)) {

                return firstNMoves.get(i).get(1);
            }
        }

        throw new IllegalArgumentException("No first move found for the player " + forId + ".");
    }

    private List<String> preparePlayersPositionResult(LinkedHashMap<Integer, Player> playerMap, Integer total) {
        List<String> playersPosition = new ArrayList<>(total);

        if (playerMap.size() == 0) {
            return playersPosition;
        }

        for(int i = 0; i< playerMap.size(); i++) {
            Player player = playerMap.get(i+1);
            playersPosition.add("Player " + player.getPlayerId() + " is at " + player.getCurrentPosition());
        }

        return playersPosition;
    }
}
