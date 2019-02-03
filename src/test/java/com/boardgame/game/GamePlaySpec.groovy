package com.boardgame.game

import com.boardgame.builder.GameBuilder
import com.boardgame.builder.GameType
import com.boardgame.controller.CustomRequest
import com.boardgame.controller.CustomResponse
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class GamePlaySpec extends Specification {
    @Shared Game snakeLadderBoardGame = GameBuilder.getGameBoard(GameType.SNAKE_BOARD)

    void "test start method with valid CustomRequest input"() {
        given: 'A valid instance of CustomRequest'
        CustomRequest customRequest = new CustomRequest(2, [[1, 6], [2, 3]], [[1, 5], [2, 6], [1, 3], [2, 4], [1, 5],
                [2, 2]])

        when: 'start method is called with customRequest'
        CustomResponse customResponse = new GamePlay().start(customRequest, snakeLadderBoardGame)

        then: 'It should return the expected position of both players'
        customResponse.playersPosition[0] == 'Player 1 - 60'
        customResponse.playersPosition[1] == 'Player 2 - 14'
    }

    void "test start method with invalid CustomRequest input combination"() {
        given: 'A invalid instance of CustomRequest'
        CustomRequest customRequest = new CustomRequest(3, [[1, 6], [2, 3], [1]], [[1, 5], [2, 6]])

        when: 'start method is called with customRequest'
        new GamePlay().start(customRequest, snakeLadderBoardGame)

        then: 'It should throw IllegalArgumentException with message'
        IllegalArgumentException exception = thrown()
        exception.message == 'No first move found for the player 3.'
    }

    @Unroll
    void "test start method with invalid CustomRequest input combination for the first #givenN players"() {
        given: 'A invalid instance of CustomRequest'
        CustomRequest customRequest = new CustomRequest(givenN, [], [])

        when: 'start method is called with customRequest'
        new GamePlay().start(customRequest, snakeLadderBoardGame)

        then: 'It should throw IllegalArgumentException with message'
        IllegalArgumentException exception = thrown()
        exception.message == 'This game cannot be played with less than 2 and max 6 players.'

        where: 'Values of givenN is following.'
        givenN << [100, 50, 1000]
    }
}