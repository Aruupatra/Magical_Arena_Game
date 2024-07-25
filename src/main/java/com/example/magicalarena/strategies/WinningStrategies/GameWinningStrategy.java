package com.example.magicalarena.strategies.WinningStrategies;

import com.example.magicalarena.models.Player;

import java.util.List;

public interface GameWinningStrategy {
    void checkWinner(List<Player> players);
}
