package com.boardgame.builder

import com.boardgame.exception.InvalidGameSelected
import com.boardgame.game.Game
import spock.lang.Specification

class GameBuilderSpec extends Specification {

    void "test getGameBoard method is called with valid game type"() {
        when: "getGameBoard method called"
        Game game = GameBuilder.getGameBoard(GameType.SNAKE_BOARD)

        then: 'game type should be SnakeLadderBoard'
        assert game
        assert game.getGameName() == 'Snake-Ladder Game'
    }

    void "test getGameBoard method with invalid type"() {
        when: "getGameBoard method is called"
        GameBuilder.getGameBoard(GameType.UNKNOWN)

        then: 'it should throw InvalidGameSelected with message'
        InvalidGameSelected exception = thrown()
        exception.message == 'Selected game is not available to create.'
    }
}