package com.example.playing.card.card.module;

import com.example.playing.card.card.enums.CardNumber;
import com.example.playing.card.card.enums.CardType;

public class Card {

    private CardType cardType;
    private CardNumber cardNumber;

    public Card(CardType cardType, CardNumber cardNumber) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }

    public CardType getCardType() {
        return cardType;
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }
}
