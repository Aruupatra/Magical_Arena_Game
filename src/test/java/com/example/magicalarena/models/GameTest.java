package com.example.magicalarena.models;

import static org.junit.jupiter.api.Assertions.*;
import com.example.magicalarena.Exceptions.PlayerException;
import com.example.magicalarena.strategies.WinningStrategies.AnyOneBecomesZero;
import com.example.magicalarena.strategies.WinningStrategies.GameWinningStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testGameInitialization() throws PlayerException {
        List<Player> players = new ArrayList<>();
        players.add(new Player("A", 50, 5, 10, PlayerType.HUMAN));
        players.add(new Player("B", 100, 10, 5, PlayerType.HUMAN));

        List<GameWinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new AnyOneBecomesZero());

        try {
            Game game = new Game(players, winningStrategies);
            assertNotNull(game);
        } catch (PlayerException e) {
            e.printStackTrace();

        }
    }

    @Test
    void testGameInitializationSinglePlayer() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("A", 50, 5, 10, PlayerType.HUMAN));

        List<GameWinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new AnyOneBecomesZero());

        assertThrows(PlayerException.class, () -> new Game(players, winningStrategies));

    }

    @Test
    void testPlayGame() throws PlayerException {
        Player playerA = new Player("A", 50, 5, 10, PlayerType.HUMAN);
        Player playerB = new Player("B", 100, 10, 5, PlayerType.HUMAN);
        List<Player> players = new ArrayList<>();
        players.add(playerA);
        players.add(playerB);

        List<GameWinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new AnyOneBecomesZero());

        Game game = new Game(players, winningStrategies);
        game.play();

        assertTrue(playerA.getHealth() == 0 || playerB.getHealth() == 0);
        assertTrue(playerA.getHealth() <= 0 || playerB.getHealth() <= 0);
    }

    @Test
    void testWinner() throws PlayerException {
        Player playerA = new Player("A", 50, 5, 10, PlayerType.HUMAN);
        Player playerB = new Player("B", 100, 10, 5, PlayerType.HUMAN);
        List<Player> players = new ArrayList<>();
        players.add(playerA);
        players.add(playerB);

        List<GameWinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new AnyOneBecomesZero());

        Game game = new Game(players, winningStrategies);
        game.play();

        Player winner = game.getWinner();
        assertNotNull(winner);
        assertTrue(winner == playerA || winner == playerB);
    }
}
