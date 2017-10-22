package com.inclusivity.poker.analysers;

import com.inclusivity.poker.Card;
import com.inclusivity.poker.Rank;

import java.util.*;

/**
 * This class analyses a hand in terms of matching rank
 * It has state and knows things like:
 * <p>
 * We have 2 TENS and two THREES
 * <p>
 * hasTwoPairs() would be true in this case
 */
public class RankAnalyser {

    List<Card> listOfCards;

    Map<Rank, Integer> countsPerRank = new HashMap<>();

    public RankAnalyser(List<Card> listOfCards) {

        this.listOfCards = listOfCards;
        buildUpRankCountsPerRank(listOfCards);

    }

    public boolean hasOnePairOnly() {
        //8. One pair, or simply a pair, is a poker hand containing two cards of
        //    the same rank and three cards of three other ranks
        if (countsPerRank.keySet().size() == 4) {

            //If one of these ranks found has 2 then return true
            for (Rank rank : countsPerRank.keySet()) {
                int numberOfSameRank = countsPerRank.get(rank);
                if (numberOfSameRank == 2) {
                    return true;
                }
            }

        }

        return false;

    }

    public boolean hasTwoPairs() {
        //7. Two pair is a poker hand containing two cards of the same rank, two
        //    cards of another rank and one card of a third rank
        if (countsPerRank.keySet().size() == 3) {

            //If one of these ranks found has 2 and then another has 2 of the same, return true
            for (Rank rank : countsPerRank.keySet()) {
                int numberOfSameRank = countsPerRank.get(rank);
                if (numberOfSameRank == 2) {

                    //I suppose I should be using recursion here
                    for (Rank secondRank : countsPerRank.keySet()) {
                        int numberOfSecondRank = countsPerRank.get(secondRank);
                        if (numberOfSecondRank == 2) {
                            return true;
                        }
                    }

                }
            }

        }

        return false;

    }

    public boolean hasTripsOnly() {
        //6. Three of a kind, also known as trips or a set, is a poker hand
        //    containing three cards of the same rank and two cards of two other ranks

        if (countsPerRank.keySet().size() > 2) {

            //If one of these ranks found has 3 of the same then return true
            for (Rank rank : countsPerRank.keySet()) {
                int numberOfSameRank = countsPerRank.get(rank);
                if (numberOfSameRank == 3) {
                    return true;
                }
            }

        }

        return false;

    }

    /**
     * Check if we have three of a kind AND two of a kind
     *
     * @return boolean if we have three of a kind AND two of a kind
     */
    public boolean hasTripsAndAPair() {

        //3. A full house, also known as a full boat or tight[citation needed]
        // (and originally called a full hand), is a poker hand containing three
        //  cards of one rank and two cards of another rank

        if (countsPerRank.keySet().size() == 2) {

            //If one of these two ranks found has 3 of the same
            // and the other has 2 of the same then return true
            for (Rank rank : countsPerRank.keySet()) {
                int numberOfSameRank = countsPerRank.get(rank);
                if (numberOfSameRank == 3) {

                    //I suppose I should be using recursion here
                    for (Rank secondRank : countsPerRank.keySet()) {
                        int numberOfSecondRank = countsPerRank.get(secondRank);
                        if (numberOfSecondRank == 2) {
                            return true;
                        }
                    }

                }
            }

        }

        return false;
    }

    /**
     * Check if we have four of a kind (4 cards with the same Rank)
     *
     * @return boolean if we have four of a kind
     */
    public boolean hasFourOfAKind() {

        //2. Four of a kind, also known as quads, is a poker hand containing
        //four cards of the same rank and one card of another rank

        if (countsPerRank.keySet().size() == 2) {

            //If one of these two ranks found has 4 of the same, return true
            for (Rank rank : countsPerRank.keySet()) {
                int numberOfSameRank = countsPerRank.get(rank);
                if (numberOfSameRank == 4) {
                    return true;
                }
            }

        }

        return false;

    }

    /**
     * Checks if we have five of a kind (5 cards with the same Rank)
     *
     * @return boolean if we have five of a kind
     */
    public boolean hasFiveOfAKind() {

        //0. Five of a kind(Royal Flush) is a poker hand containing five cards of the same rank
        //Since there are only 4 of the same rank in a standard deck, you need a wildcard to simulate this

        if (countsPerRank.keySet().size() == 1) {

            for (Rank rank : countsPerRank.keySet()) {
                int numberOfSameRank = countsPerRank.get(rank);
                return (numberOfSameRank == 5);
            }

        }

        return false;

    }


    public boolean hasFiveCardsOfSequentialRank() {
        //5. A straight is a poker hand containing five cards of sequential
        //rank, NOT all of the same suit,
//        1. A straight flush is a poker hand containing five cards of
//    sequential rank, all of the same suit,

        //4. A flush is a poker hand containing five cards all of the same suit,
        // NOT all of sequential rank,

        if (countsPerRank.keySet().size() == 5) {

            //Get the ranks of all cards, and sort them.
            //Then check that they increment by one

            List<Integer> listOfRanks = new ArrayList<>();
            for (Card card : listOfCards) {
                listOfRanks.add(card.getRank().getValue());
            }

            Collections.sort(listOfRanks, (a, b) -> a.compareTo(b));

            int previousValue = 0;
            boolean firstItem = true;
            for (Integer currentValue : listOfRanks) {

                if (!firstItem) {

                    int difference = currentValue - previousValue;

                    if (difference != 1) {
                        return false;
                    }

                    previousValue = currentValue;

                } else {
                    firstItem = false;
                    previousValue = currentValue;
                }

            }

            return true;

        } else {
            return false;
        }

    }

    private void buildUpRankCountsPerRank(List<Card> listOfCards) {
        //We build up a list of counts per Rank
        for (Card card : listOfCards) {
            if (countsPerRank.containsKey(card.getRank())) {
                Integer currentCount = countsPerRank.get(card.getRank());
                countsPerRank.put(card.getRank(), currentCount + 1);
            } else {
                countsPerRank.put(card.getRank(), 1);
            }

        }
    }

    protected Map<Rank, Integer> getCountsPerRank() {
        return countsPerRank;
    }

}
