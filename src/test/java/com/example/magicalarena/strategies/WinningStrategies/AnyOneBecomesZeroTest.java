package com.example.magicalarena.strategies.WinningStrategies;

import static org.junit.jupiter.api.Assertions.*;

import com.example.magicalarena.models.Player;
import com.example.magicalarena.models.PlayerType;
import com.example.magicalarena.strategies.WinningStrategies.AnyOneBecomesZero;
import com.example.magicalarena.strategies.WinningStrategies.GameWinningStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnyOneBecomesZeroTest {

    @Test
    void testCheckWinner() {
        Player playerA = new Player("A", 0, 5, 10, PlayerType.HUMAN);
        Player playerB = new Player("B", 100, 10, 5, PlayerType.HUMAN);

        List<Player> players = new ArrayList<>();
        players.add(playerA);
        players.add(playerB);

        GameWinningStrategy strategy = new AnyOneBecomesZero();
        strategy.checkWinner(players);

        assertTrue(!playerA.isAlive() || !playerB.isAlive());
    }
}
