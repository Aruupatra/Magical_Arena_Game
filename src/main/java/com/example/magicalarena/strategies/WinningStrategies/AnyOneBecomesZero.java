package com.example.magicalarena.strategies.WinningStrategies;

import com.example.magicalarena.models.Player;

import java.util.List;

public class AnyOneBecomesZero implements GameWinningStrategy{


    @Override
    public Player checkWinner(List<Player> players) {

        System.out.println("Winner checking");
      Player playerA=players.get(0);
      Player playerB=players.get(1);
        if (playerA.isAlive()) {
            System.out.println(playerA.getName() + " wins!");
            return playerA;
        } else {
            System.out.println(playerB.getName() + " wins!");
            return playerA;
        }

    }
}
