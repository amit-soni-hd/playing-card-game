package com.example.playing.card.game;

import com.example.playing.card.card.module.Card;
import com.example.playing.card.card.service.CardService;
import com.example.playing.card.player.Piles;
import com.example.playing.card.player.Player;
import com.example.playing.card.player.PlayerService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

@Slf4j
public class CardGameService implements Game {

    /**
     * used for start the game between two player
     * First get the list of card and shuffle the card
     * distribute the cars between the player
     * create map and store the entry player contains cards
     * Piles class contain 2 variable 1 currentPile and second winCardsPile
     * stack used for table for put the cards
     * @param players contain the two player
     */
    public void startGame(List<Player> players) {

        CardService cardService = new CardService();
        PlayerService playerService = new PlayerService();

        List<Card> cardList = cardService.getCardList();
        cardService.cardShuffling(cardList);

        Player playerChance = playerService.getFirstPlayerChance(players);
        playerChance.setChance(true);

        Map<Player, Piles> playerPilesMap = cardService.cardDistribution(cardList, players);



        Stack<Card> table = new Stack<>();
        while (true) {

            Player player = playerService.getPlayerChance(players);
            Piles piles = playerPilesMap.get(player);

            Queue<Card> currentPile = piles.getCurrentPile();
            List<Card> winCardsPile = piles.getWinCardsPile();


            if(currentPile.isEmpty()) {
                cardService.cardShuffling(winCardsPile);
                currentPile.addAll(winCardsPile);
            }

            if(currentPile.isEmpty()) {
                player.setResult(false);
                break;
            }

            Card currentCard = currentPile.remove();
            log.info("Player {} put the card {} {}" , player.getPlayerName(), currentCard.getCardNumber(), currentCard.getCardType() );

            if(table.empty()) {

               table.push(currentCard);

            } else {

                Card topCard = table.peek();
                boolean result = compareCard(topCard, currentCard);

                if(result) {
                    List<Card> collectCards = table.stream().collect(Collectors.toList());
                    log.info("Win cards from table {}", collectCards.toArray());
                    winCardsPile.add(currentCard);
                    winCardsPile.addAll(collectCards);
                    table.removeAllElements();
                } else {
                    table.push(currentCard);
                }
            }
            playerService.giveChanceToOther(players);
        }
    }

    /**
     * method for compare the 2 cards
     * @param topCard stand for top card of table
     * @param currentCard stand for current card which player used to play the game
     * @return true if current card is higher then top card of table
     */
    private boolean compareCard(Card topCard, Card currentCard) {
        return topCard.getCardNumber().compareTo(currentCard.getCardNumber()) > 0 ? true : false;
    }
}
