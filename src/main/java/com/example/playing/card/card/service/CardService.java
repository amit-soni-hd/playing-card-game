package com.example.playing.card.card.service;


import com.example.playing.card.card.module.Card;
import com.example.playing.card.card.enums.CardNumber;
import com.example.playing.card.card.enums.CardType;
import com.example.playing.card.player.Piles;
import com.example.playing.card.player.Player;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class CardService implements CardServiceInterface  {

    /**
     * used for generate the list of card
     * @return list of card
     */
    public List<Card> getCardList() {

        log.info("Generate the Card list.............");
        List<Card> cardList = new ArrayList<>();
        for (CardType cardType: CardType.values()) {
            for (CardNumber cardNumber: CardNumber.values()) {
                Card card = new Card(cardType, cardNumber);
                cardList.add(card);
            }
        }
        return cardList;
    }


    /**
     * used to shuffle the card
     * @param cardList the list of card
     */
    public void cardShuffling(List<Card> cardList) {

        log.info("Shuffle the card........");
        Collections.shuffle(cardList);
    }


    /**
     * used to distribute the card between player
     * @param cardList list of card
     * @param players list of player
     * @return map key -> player and value-> Piles class which contain current pile and win card pile
     */
    public Map<Player, Piles> cardDistribution(List<Card> cardList, List<Player> players) {

        log.info("Distribute the card between two player..........");
        Map<Player, Piles> playersCard = new HashMap<>(2);

        playersCard.put(players.get(0), new Piles());
        playersCard.put(players.get(1), new Piles());

        boolean flag = true;

        for (Card card: cardList ) {

            if(flag == true) {
                playersCard.get(players.get(0)).getCurrentPile().add(card);
                flag = false;
            } else {
                playersCard.get(players.get(1)).getCurrentPile().add(card);
                flag = true;
            }
        }
        return playersCard;
    }

}
