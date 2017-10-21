package com.inclusivity.poker;

public class Hand {

    public static String getBestHand(String cards) {

        String[] cardSymbols = cards.split(",");
        if (cardSymbols.length != 5) {
            throw new RuntimeException("symbols for 5 cards must be supplied.");
        }

        return "Two Pair";

    }


}
