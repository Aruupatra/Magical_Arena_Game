package com.example.magicalarena.controlers;

import static org.junit.jupiter.api.Assertions.*;

import com.example.magicalarena.Exceptions.PlayerException;
import com.example.magicalarena.controlers.GameController;
import com.example.magicalarena.models.Game;
import com.example.magicalarena.models.Player;
import com.example.magicalarena.models.PlayerType;
import com.example.magicalarena.strategies.WinningStrategies.AnyOneBecomesZero;
import com.example.magicalarena.strategies.WinningStrategies.GameWinningStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    @Test
    void testStartGame() throws PlayerException {
        GameController gameController = new GameController();

        List<Player> players = new ArrayList<>();
        players.add(new Player("A", 50, 5, 10, PlayerType.HUMAN));
        players.add(new Player("B", 100, 10, 5, PlayerType.HUMAN));

        List<GameWinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new AnyOneBecomesZero());

        Game game = gameController.startGame(players, winningStrategies);
        assertNotNull(game);
    }

    @Test
    void testStartGameWithSinglePlayer() {
        GameController gameController = new GameController();

        List<Player> players = new ArrayList<>();
        players.add(new Player("A", 50, 5, 10, PlayerType.HUMAN));

        List<GameWinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new AnyOneBecomesZero());

        assertThrows(PlayerException.class, () -> gameController.startGame(players, winningStrategies));
    }
}
