package com.example.playing.card.card.enums;

/**
 * Enum class for storing the cards
 */
public enum CardNumber {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(
            14);

    private Integer number;

    /**
     * constructor for set the value of card
     * @param number no of card
     */
    CardNumber(Integer number) {
        this.number = number;
    }

}
