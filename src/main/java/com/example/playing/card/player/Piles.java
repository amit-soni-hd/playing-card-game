package com.example.playing.card.player;

import com.example.playing.card.card.module.Card;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Piles {

    private Queue<Card> currentPile;
    private List<Card> winCardsPile;

    public Piles() {
        this.currentPile = new LinkedList<>();
        this.winCardsPile = new ArrayList<>();
    }

    public Queue<Card> getCurrentPile() {
        return currentPile;
    }

    public List<Card> getWinCardsPile() {
        return winCardsPile;
    }
}
