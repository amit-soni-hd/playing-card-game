package com.example.playing.card.player;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceTest {

    @InjectMocks
    private PlayerService playerService;

    private List<Player> players;

    @Before
    public void setUp() {
        this.players = new ArrayList<>(2);
        players.add(new Player("Radha", true, false));
        players.add(new Player("Krishna",true, false));
    }

    @Test
    public void getFirstPlayerChance() {

        Player playerChance = playerService.getFirstPlayerChance(players);
        assertTrue(players.contains(playerChance));

    }

    @Test
    public void getPlayerChanceTest() {
        players.get(0).setChance(true);
        Player player = playerService.getPlayerChance(players);
        assertTrue(players.contains(player));
    }

    @Test
    public void getWinnerTest() {
        players.get(0).setResult(true);
        Player player = playerService.getWinner(players);
        assertTrue(player.getResult());
    }
    @Test
    public void getWinnerTest_1() {

        players.get(0).setResult(false);
        Player player1 = playerService.getWinner(players);
        assertTrue(player1.getResult());

    }

    @Test
    public void giveChanceToOtherTest() {

        players.get(0).setChance(true);
        playerService.giveChanceToOther(players);
        assertFalse(players.get(0).getChance());
        assertTrue(players.get(1).getChance());

    }

    @Test
    public void giveChanceToOtherTest_1() {

        playerService.giveChanceToOther(players);
        assertFalse(players.get(1).getChance());
        assertTrue(players.get(0).getChance());
    }


}
