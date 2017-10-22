package com.inclusivity.poker.analysers;

import com.inclusivity.poker.Card;
import com.inclusivity.poker.Suit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class analyses a hand in terms of matching suit
 * It has state and can tell you things like:
 *
 * We have 2 diamonds, 1 heart, 3 spades and 0 clubs
 *
 */
public class SuitAnalyser {

    List<Card> listOfCards;

    //e.g. We have 2 diamonds, 1 heart, 3 spades and 0 clubs
    Map<Suit, Integer> countsPerSuit = new HashMap<>();


    public SuitAnalyser(List<Card> listOfCards) {
        this.listOfCards = listOfCards;
        buildUpSuitCountsPerSuit(listOfCards);


    }

    private void buildUpSuitCountsPerSuit(List<Card> listOfCards) {
        //We build up a list of counts per Suit
        for (Card card: listOfCards) {
            if (countsPerSuit.containsKey(card.getSuit())) {
                Integer currentCount = countsPerSuit.get(card.getSuit());
                countsPerSuit.put(card.getSuit(), currentCount+1);
            } else {
                countsPerSuit.put(card.getSuit(), 1);
            }

        }
    }

    public Map<Suit, Integer> getCountsPerSuit() {
        return countsPerSuit;
    }
}
