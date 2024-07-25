package com.example.magicalarena.strategies.WinningStrategies;

import com.example.magicalarena.models.Player;

import java.util.List;

public interface GameWinningStrategy {
    Player checkWinner(List<Player> players);
}
