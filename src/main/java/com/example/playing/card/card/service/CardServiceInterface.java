package com.example.playing.card.card.service;

import com.example.playing.card.card.module.Card;
import com.example.playing.card.player.Piles;
import com.example.playing.card.player.Player;

import java.util.List;
import java.util.Map;

public interface CardServiceInterface {

    List<Card> getCardList();
    void cardShuffling(List<Card> cardList);
    Map<Player, Piles> cardDistribution(List<Card> cardList, List<Player> players);
}
