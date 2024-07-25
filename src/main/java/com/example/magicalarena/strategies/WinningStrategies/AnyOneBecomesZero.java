package com.example.magicalarena.strategies.WinningStrategies;

import com.example.magicalarena.models.Player;

import java.util.List;

public class AnyOneBecomesZero implements GameWinningStrategy{


    @Override
    public void checkWinner(List<Player> players) {

        System.out.println("Winner checking");
      Player playerA=players.get(0);
      Player playerB=players.get(1);
        if (playerA.isAlive()) {
            System.out.println(playerA.getName() + " wins!");
        } else {
            System.out.println(playerB.getName() + " wins!");
        }

    }
}
