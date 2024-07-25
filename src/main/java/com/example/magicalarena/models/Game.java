package com.example.magicalarena.models;

import com.example.magicalarena.Exceptions.PlayerException;
import com.example.magicalarena.strategies.WinningStrategies.GameWinningStrategy;


import java.util.List;
import java.util.Random;


public class Game {

    private List<Player> players;
    private Player winner;
    private GameState gameState;
    private int nextPlayerMoveIndex;
    private List<GameWinningStrategy> winningStrategies;
    private Random r=new Random();

    public Game(List<Player> players,List<GameWinningStrategy> winningStrategies) throws PlayerException {
        validatePlayer(players);
        this.players=players;
        this.winningStrategies=winningStrategies;
        winner=null;
        gameState=GameState.IN_PROGRESS;
        int idx=-1;
        int max=Integer.MAX_VALUE;
        for(int i=0;i<players.size();i++)
        {
            Player player=players.get(i);
            if(player.getHealth()<max)
            {
                max=player.getHealth();
                idx=i;
            }
        }
        nextPlayerMoveIndex=idx;
    }
    public void validatePlayer(List<Player> players) throws PlayerException {
        if(players.size()!=1)
        {
            throw new PlayerException("There must be two player");
        }
    }

  public GameState getGameState()
  {
      return this.gameState;
  }
    public Player getWinner()
    {
        return this.winner;
    }
  public void play()
  {
      Player playerA=players.get(nextPlayerMoveIndex);
      Player playerB=players.get(1-nextPlayerMoveIndex);
      while (playerA.isAlive() && playerB.isAlive()) {
          takeTurn(playerA, playerB);
          if (!playerB.isAlive()) break;
          takeTurn(playerB, playerA);
      }

      for(GameWinningStrategy winningStrategy:winningStrategies)
      {
          winningStrategy.checkWinner(players);
      }
  }
  private void takeTurn(Player attacker, Player defender) {
        int attackDamage = attacker.calculateAttackDamage();
        int defense = defender.calculateDefense();
        int damage = attackDamage - defense;

        if (damage > 0) {
            defender.takeDamage(damage);
            System.out.println(attacker.getName() + " deals " + damage + " damage to " + defender.getName());
        } else {
            System.out.println(defender.getName() + " defends the attack!");
        }

        System.out.println(defender.getName() + "'s remaining health: " + defender.getHealth());
    }



    public static Builder getBuilder()
    {
       return new Builder();
    }



    public static class Builder
    {
        private List<Player> players;
        private List<GameWinningStrategy> winningStrategies;

        public Builder setPlayers(List<Player> players)
        {
            this.players=players;
            return this;
        }

        public  Builder setWinningStrategies(List<GameWinningStrategy> winningStrategies)
        {
            this.winningStrategies=winningStrategies;
            return this;
        }
        public Game build() throws PlayerException {
          return new Game(players,winningStrategies);
        }
    }

}
