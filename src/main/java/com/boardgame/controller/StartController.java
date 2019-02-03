package com.boardgame.controller;

import com.boardgame.builder.GameBuilder;
import com.boardgame.builder.GameType;
import com.boardgame.exception.InvalidGameSelected;
import com.boardgame.game.Game;
import com.boardgame.game.GamePlay;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import javax.validation.constraints.Size;

@Controller("/")
public class StartController {

    @Post(value = "/play", consumes = MediaType.APPLICATION_JSON)
    CustomResponse play(@Size(max = 1024) @Body CustomRequest request) {
        CustomResponse response = new CustomResponse();
        Game snakeLadderGame;

        try {
            request.validateRequest();
            snakeLadderGame = GameBuilder.getGameBoard(GameType.SNAKE_BOARD);
        } catch (InvalidGameSelected | IllegalArgumentException exception) {
            response.setErrorMessage(exception.getMessage());

            return response;
        }

        return new GamePlay().start(request, snakeLadderGame);
    }
}
