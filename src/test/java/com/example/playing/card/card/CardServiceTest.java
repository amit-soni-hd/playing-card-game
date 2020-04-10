package com.example.playing.card.card;

import com.example.playing.card.card.module.Card;
import com.example.playing.card.card.service.CardService;
import com.example.playing.card.player.Piles;
import com.example.playing.card.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CardServiceTest {

    @InjectMocks
    private CardService cardService;

    private List<Player> players;

    @Before
    public void setUp() {
        this.players = new ArrayList<>(2);
        players.add(new Player("Radha", true, false));
        players.add(new Player("Krishna",true, false));
    }

    @Test
    public void getCardList() {
        List<Card> cardList = cardService.getCardList();
        assertTrue(cardList.size() == 52);
    }

    @Test
    public void cardShufflingTest() {
        List<Card> cardList = cardService.getCardList();
        Card card = cardList.get(0);
        cardService.cardShuffling(cardList);
        assertFalse(cardList.get(0).equals(card));
    }

    @Test
    public void cardDistributionTest() {
        List<Card> cardList = cardService.getCardList();
        Map<Player, Piles> playerPilesMap = cardService.cardDistribution(cardList, players);
        assertTrue(playerPilesMap.get(players.get(0)).getCurrentPile().size() == 26);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void cardDistributionTest_1() {
        List<Player> playerList = new ArrayList<>(1);
        List<Card> cardList = cardService.getCardList();
        playerList.add(new Player("amit", false, false));

        cardService.cardDistribution(cardList, playerList);
    }


}
