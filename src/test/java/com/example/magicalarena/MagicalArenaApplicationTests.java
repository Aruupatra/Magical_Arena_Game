package com.example.magicalarena;

import com.example.magicalarena.models.Player;
import com.example.magicalarena.models.PlayerType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MagicalArenaApplicationTests {



    @Test
    public void testPlayerCreation() {
        Player player = new Player("A", 50, 5, 10, PlayerType.HUMAN);
        assertEquals("A", player.getName());
        assertEquals(50, player.getHealth());
        assertEquals(5, player.getStrength());
        assertEquals(10, player.getAttack());
        assertEquals(PlayerType.HUMAN, player.getPlayerType());

    }
    @Test
    public void testCalculateAttackDamage() {
        Player player = new Player("A", 50, 5, 10,PlayerType.HUMAN);
        int damage = player.calculateAttackDamage();
        assertTrue(damage >= 10 && damage <= 60); // 1*10 to 6*10
    }

}
