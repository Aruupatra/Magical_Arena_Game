package com.example.magicalarena.controlers;

import com.example.magicalarena.models.Game;
import com.example.magicalarena.models.Player;
import com.example.magicalarena.strategies.WinningStrategies.GameWinningStrategy;

import java.util.List;

public class GameController {


    public Game startGame(List<Player> players, List<GameWinningStrategy> winningStrategy)
    {
        return Game.getBuilder().
                setPlayers(players).
                setWinningStrategies(winningStrategy)
                .build();

    }
}
