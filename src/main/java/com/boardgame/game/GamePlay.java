package com.boardgame.game;

import com.boardgame.controller.CustomRequest;
import com.boardgame.controller.CustomResponse;
import com.boardgame.exception.GameEndException;
import com.boardgame.exception.InvalidMoveException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * This class where {@link CustomRequest} is processed for {@link Game} and {@link Player}.
 */
public class GamePlay {

    /**
     * This method starts the game with the inputs and {@link Game} type.
     * @param request {@link CustomRequest}
     * @param game {@link Game}
     * @return {@link CustomResponse}
     */
    public CustomResponse start(CustomRequest request, Game game) throws IllegalArgumentException {
        CustomResponse response = new CustomResponse();
        request.validateRequest();

        List<List<Integer>> firstNMoves = request.getFirstNMoves();
        Integer totalN = request.getN();
        List<List<Integer>> playersMoves = request.getPlayersMove();


        List<Player> players = createPlayers(totalN, game, firstNMoves);

        sortPlayers(players);

        LinkedHashMap<Integer, Player> playersMap = new LinkedHashMap<>();
        for(int i =0; i< players.size(); i++) {
            playersMap.put(players.get(i).getPlayerId(), players.get(i));
        }


        for (int index = 0; index < playersMoves.size(); index++) {
            List<Integer> playerIdWithMoveBy = playersMoves.get(index);

            Player player = playersMap.get(playerIdWithMoveBy.get(0));

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

        response.setPlayersPosition(preparePlayersPositionResult(playersMap, totalN));

        return response;
    }

    /**
     * Prepares the position of each {@link Player} for the response if none won the match in the last.
     * @param playerMap {@link LinkedHashMap<Integer, Player>}
     * @param total {@link Integer}
     * @return {@link List<String>}
     */
    private List<String> preparePlayersPositionResult(LinkedHashMap<Integer, Player> playerMap, Integer total) {
        List<String> playersPosition = new ArrayList<>(total);

        if (playerMap.size() == 0) {
            return playersPosition;
        }

        for(int i = 0; i< playerMap.size(); i++) {
            Player player = playerMap.get(i+1);
            playersPosition.add("Player " + player.getPlayerId() + " - " + player.getCurrentPosition());
        }

        return playersPosition;
    }

    /**
     * This method returns the first turn of the player if provided in the input.
     * @param firstNMoves {@link List<List<Integer>}
     * @param forId {@link Integer}
     * @return {@lin Integer}
     * @throws IllegalArgumentException - When no turn is defined for the given player Id.
     */
    private static Integer getFirstTurn(List<List<Integer>> firstNMoves, Integer forId)
            throws IllegalArgumentException {
        for(int i =0; i < firstNMoves.size(); i++) {
            if (firstNMoves.get(i).get(0).equals(forId)) {

                return firstNMoves.get(i).get(1);
            }
        }

        throw new IllegalArgumentException("No first move found for the player " + forId + ".");
    }

    /**
     * This method creates the {@link Player} for the given number of players and {@link Game}.
     * @param totalN {@link Integer}
     * @param game {@link SnakeLadderBoard}
     * @param firstNMoves {@link List<List<Integer>>}
     * @return {@link List<Player>}
     */
    private static List<Player> createPlayers(Integer totalN, Game game, List<List<Integer>> firstNMoves) {
        // To get the ordered entries of players in the map.
        List<Player> players = new ArrayList<>(totalN);

        // Create players
        for (int i = 1; i <= totalN; i++) {
            players.add(new Player(i, game, getFirstTurn(firstNMoves, i)));
        }

        return players;
    }

    /**
     * Sort the {@link Player} by their turn based on the input.
     * @param players {@link List<Player>} being sort.
     */
    private static void sortPlayers(List<Player> players) {
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
    }
}
