package com.inclusivity.poker;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    public static String getBestHand(String cards) {

        String[] cardSymbols = cards.split(",");
        if (cardSymbols.length != 5) {
            throw new RuntimeException("symbols for 5 cards must be supplied.");
        }

        return "Two Pair";

    }

    protected static List<Card> getListOfCards(String cards) {

        String[] cardSymbols = cards.split(",");
        if (cardSymbols.length != 5) {
            throw new RuntimeException("symbols for 5 cards must be supplied.");
        }

        List<Card> listOfCards = new ArrayList<>();

        for (String cardSymbol:cardSymbols) {
            listOfCards.add(Card.buildFromShortCode(cardSymbol));

        }

        return listOfCards;

    }

}
