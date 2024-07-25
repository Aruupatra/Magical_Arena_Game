package com.example.magicalarena.models;

import com.example.magicalarena.models.Player;
import com.example.magicalarena.models.PlayerType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testPlayerCreation() {
        Player player = new Player("A", 50, 5, 10, PlayerType.HUMAN);
        assertEquals("A", player.getName());
        assertEquals(50, player.getHealth());
        assertEquals(5, player.getStrength());
        assertEquals(10, player.getAttack());
        assertEquals(PlayerType.HUMAN, player.getPlayerType());
    }

    @Test
    void testCalculateAttackDamage() {
        Player player = new Player("A", 50, 5, 10, PlayerType.HUMAN);
        int damage = player.calculateAttackDamage();
        assertTrue(damage >= 10 && damage <= 60); // 1*10 to 6*10
    }

    @Test
    void testCalculateDefense() {
        Player player = new Player("A", 50, 5, 10, PlayerType.HUMAN);
        int defense = player.calculateDefense();
        assertTrue(defense >= 5 && defense <= 30); // 1*5 to 6*5
    }

    @Test
    void testTakeDamage() {
        Player player = new Player("A", 50, 5, 10, PlayerType.HUMAN);
        player.takeDamage(30);
        assertEquals(20, player.getHealth());
    }

    @Test
    void testTakeDamageExceedsHealth() {
        Player player = new Player("A", 50, 5, 10, PlayerType.HUMAN);
        player.takeDamage(60);
        assertEquals(0, player.getHealth());
    }

    @Test
    void testIsAlive() {
        Player player = new Player("A", 50, 5, 10, PlayerType.HUMAN);
        assertTrue(player.isAlive());
        player.takeDamage(50);
        assertFalse(player.isAlive());
    }
}
