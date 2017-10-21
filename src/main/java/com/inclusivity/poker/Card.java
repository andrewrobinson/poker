package com.inclusivity.poker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * A Card has Rank and Suit
 *
 * It can be built from shortCodes such as "AS, 10C, 10H, 3D, 3S", using buildFromShortCode
 *
 * Internally, this uses buildFromRankCodeAndSuitCode and a shortCode of "10C"
 * becomes rankCode of "10" and suitCode of "C"
 *
 */
public class Card {

    Rank rank;
    Suit suit;

    //This looks for a number or A, J, Q or K as the first group (the rank)
    //Then it looks for (S or C or H or D) as the second group (the suit)
    final static String regex = "(\\d+|A|J|Q|K)(S|C|H|D)$";
    final static Pattern pattern = Pattern.compile(regex);

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static Card buildFromShortCode(String shortCode) {

        if (shortCode == null) {
            return null;
        }

        Matcher matcher = pattern.matcher(shortCode);

        if (matcher.find()) {

            if (matcher.groupCount() == 2) {

                String rankCode = matcher.group(1);
                String suitCode = matcher.group(2);
                return new Card(Rank.fromShortCode(rankCode), Suit.fromShortCode(suitCode));

            } else {
                return null;
            }

        } else {
            return null;
        }

    }


    protected static Card buildFromRankCodeAndSuitCode(String rankCode, String suitCode) {
        return new Card(Rank.fromShortCode(rankCode), Suit.fromShortCode(suitCode));
    }

    public boolean equals(Card otherCard) {
        return (otherCard != null && this.rank.equals(otherCard.rank) && this.suit.equals(otherCard.suit));
    }

}
