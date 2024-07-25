package com.example.magicalarena;

import com.example.magicalarena.controlers.GameController;
import com.example.magicalarena.models.Game;
import com.example.magicalarena.models.GameState;
import com.example.magicalarena.models.Player;
import com.example.magicalarena.models.PlayerType;
import com.example.magicalarena.strategies.WinningStrategies.AnyOneBecomesZero;
import com.example.magicalarena.strategies.WinningStrategies.GameWinningStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class MagicalArenaApplication {

    public static void main(String[] args) {
        //SpringApplication.run(MagicalArenaApplication.class, args);
        System.out.println("hi");
        GameController gameController=new GameController();
        List<Player> players=new ArrayList<>();
        players.add(new Player("A",50,5,10, PlayerType.HUMAN));
        players.add(new Player("B",100,10,5, PlayerType.HUMAN));

        GameWinningStrategy anyOneBecomesZero=new AnyOneBecomesZero();
        List<GameWinningStrategy> gameWinningStrategyList=new ArrayList<>();
        gameWinningStrategyList.add(anyOneBecomesZero);
        Game game=gameController.startGame(players,gameWinningStrategyList);
        System.out.println("player1 Health"+players.get(0).getHealth()+"player2 Health"+players.get(1).getHealth());

        game.play();

    }

}
