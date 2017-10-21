package com.inclusivity.poker;

/**
 *
 * A Card has Rank and Suit
 *
 * It can be built from shortCodes such as "AS, 10C, 10H, 3D, 3S", usind buildFromShortCode
 *
 * Internally, this uses buildFromRankCodeAndSuitCode and a shortCode of "10C"
 * becomes rankCode of "10" and suitCode of "C"
 *
 */
public class Card {

    Rank rank;
    Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

//    public static Card buildFromShortCode(String shortCode) {
//
////        "AS, 10C, 10H, 3D, 3S"
////        return new Card(Rank.fromShortCode(rankCode), Suit.fromShortCode(suitCode));
//
//    }


    protected static Card buildFromRankCodeAndSuitCode(String rankCode, String suitCode) {
        return new Card(Rank.fromShortCode(rankCode), Suit.fromShortCode(suitCode));
    }

    public boolean equals(Card otherCard) {
        return (this.rank.equals(otherCard.rank) && this.suit.equals(otherCard.suit));
    }

}
