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

    /**
     *
     * With 4 suits and 5 cards, there will always be at least 2 cards of the same suit
     * This checks for the case where all cards are of the same suit
     * Our counts per suit should have one key(only one suit), and the count for that suit should be 5
     *
     * @return boolean whether or not all cards are of the same suit
     */

    public boolean hasAllCardsOfTheSameSuit() {

        //5. A straight = none of the same suit, sequential rank only
        //4. A flush = all of the same suit, no sequential rank
        //1. A straight flush = all of the same suit AND of sequential rank

        //If this method returns true then you have a flush or a straight flush, depending on whether or not there is sequential rank
        //If this returns false, you might have a straight, if sequential rank is true

        if (countsPerSuit.keySet().size() == 1) {

            for (Suit suit: countsPerSuit.keySet()) {
                int numberOfSameSuit = countsPerSuit.get(suit);

                assert(numberOfSameSuit == 5);
                return true;

                //or if not using assert
//                if (numberOfSameSuit == 5) {
//                    return true;
//                } else {
//                    throw new RuntimeException("This should never happen! numberOfSameSuit:"+numberOfSameSuit+" should be 5 when only one Suit found in counts for suit:"+suit);
//                }

            }

        } else {
            return false;
        }

        //This should never happen since the iteration over countsPerSuit.keySet()) is guaranteed to happen since size is 1
        return false;

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

    protected Map<Suit, Integer> getCountsPerSuit() {
        return countsPerSuit;
    }

}
