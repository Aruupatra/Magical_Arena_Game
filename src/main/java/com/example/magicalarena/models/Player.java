package com.example.magicalarena.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Random;

@AllArgsConstructor
@Getter
@Setter
public class Player {

    private String name;
    private int health;
    private int strength;
    private int attack;
    private PlayerType playerType;


    public int rollDie() {
        Random rand = new Random();
        return rand.nextInt(6) + 1; // Rolling a 6-sided die
    }

    public int calculateAttackDamage() {
        int dieRoll = rollDie();
        return dieRoll * attack;
    }

    public int calculateDefense() {
        int dieRoll = rollDie();
        return dieRoll * strength;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
}
