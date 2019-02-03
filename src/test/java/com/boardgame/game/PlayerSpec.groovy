package com.boardgame.game

import com.boardgame.builder.GameBuilder
import com.boardgame.builder.GameType
import com.boardgame.exception.GameEndException
import com.boardgame.exception.InvalidMoveException
import spock.lang.Shared
import spock.lang.Specification

class PlayerSpec extends Specification {

    @Shared
    Game snakeLadderBoardGame = GameBuilder.getGameBoard(GameType.SNAKE_BOARD)

    void "test move method with sample inputs for a single player"() {
        given: 'An instance of player having ref to game game'
        Player player = new Player(1, snakeLadderBoardGame)

        when: 'move method is called with 5'
        player.move(5)

        then: 'position of player will be 25'
        player.currentPosition == 25
        player.playerId == 1

        when: 'move method is called to move 3'
        player.move(3)

        then: 'position of player should be now 55'
        player.currentPosition == 55
        player.playerId == 1

        when: 'move method is called with 5 again'
        player.move(5)

        then: 'player should be moved to 60'
        player.currentPosition == 60
        player.playerId == 1

        when: 'move method is called with some ambiguous moves to make player 1 win'
        player.move(6)
        player.move(4)
        player.move(6)
        player.move(6)

        then: 'it should throw InvalidMoveException with error message'
        InvalidMoveException exception = thrown(InvalidMoveException)
        exception.message == '101 This move cannot be made. Please try again to reach 100'

        when: 'move method called with 5 to reach 100 and win'
        player.move(5)

        then: 'it should be reach to 100'
        player.currentPosition == 100
        player.playerId == 1

        when: 'again move method called with 5 to reach 100 + 5'
        player.move(5)

        then: 'it should throw GameEndException with message'
        GameEndException endException = thrown(GameEndException)
        endException.message == 'Game ended. Winner declared.'
    }
}