package com.andrew.poker;

import com.andrew.poker.analysers.RankAnalyser;
import com.andrew.poker.analysers.SuitAnalyser;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of cards described by symbols in a comma-separated string, identify the best poker hand in it
 * <p>
 * NB - I have not ensured that the list of cards does not contain duplicates not possible in a normal pack
 */
public class Hand {

    public static final String FIVE_OF_A_KIND = "Five of a kind";
    public static final String STRAIGHT_FLUSH = "Straight flush";
    public static final String FLUSH = "Flush";
    public static final String FOUR_OF_A_KIND = "Four of a kind";
    public static final String FULL_HOUSE = "Full house";
    public static final String STRAIGHT = "Straight";
    public static final String THREE_OF_A_KIND = "Three of a kind";
    public static final String TWO_PAIR = "Two Pair";
    public static final String ONE_PAIR = "One Pair";
    public static final String HIGH_CARD = "High card";

    public static String getBestHand(String cards) {

        String[] cardSymbols = cards.split(",");
        if (cardSymbols.length != 5) {
            throw new RuntimeException("symbols for 5 cards must be supplied.");
        }

        List<Card> listOfCards = getListOfCards(cards);
        return getBestHandFromListOfCards(listOfCards);

    }

    private static String getBestHandFromListOfCards(List<Card> listOfCards) {

        RankAnalyser rankAnalyser = new RankAnalyser(listOfCards);

        if (rankAnalyser.hasFiveOfAKind()) {
            //0 Five of a kind(Royal Flush) is a poker hand containing five cards of the same rank,
            return FIVE_OF_A_KIND;
        }

        SuitAnalyser suitAnalyser = new SuitAnalyser(listOfCards);

        if (suitAnalyser.hasAllCardsOfTheSameSuit()) {

            if (rankAnalyser.hasFiveCardsOfSequentialRank()) {
                // 1. A straight flush is a poker hand containing five cards of
                // sequential rank, all of the same suit,
                return STRAIGHT_FLUSH;
            } else {
                // 4. A flush is a poker hand containing five cards all of the same suit,
                // not all of sequential rank,
                return FLUSH;
            }

        } else {

            if (rankAnalyser.hasFourOfAKind()) {
                // 2. Four of a kind, also known as quads, is a poker hand containing
                // four cards of the same rank and one card of another rank
                return FOUR_OF_A_KIND;
            }

            if (rankAnalyser.hasTripsAndAPair()) {
                // 3. A full house is a poker hand containing three
                // cards of one rank and two cards of another rank
                return FULL_HOUSE;
            }

            if (rankAnalyser.hasFiveCardsOfSequentialRank()) {
                // 5. A straight is a poker hand containing five cards of sequential
                // rank, not all of the same suit,
                return STRAIGHT;
            }

            if (rankAnalyser.hasTripsOnly()) {
                // 6. Three of a kind, also known as trips or a set, is a poker hand
                // containing three cards of the same rank and two cards of two other ranks
                return THREE_OF_A_KIND;
            }

            if (rankAnalyser.hasTwoPairs()) {
                // 7. Two pair is a poker hand containing two cards of the same rank, two
                // cards of another rank and one card of a third rank
                return TWO_PAIR;

            }

            if (rankAnalyser.hasOnePairOnly()) {
                // 8. One pair, or simply a pair, is a poker hand containing two cards of
                // the same rank and three cards of three other ranks
                return ONE_PAIR;
            }

            // 9. High card, also known as no pair or simply nothing, is a poker hand
            // containing five cards not all of sequential rank or of the same suit,
            // and none of which are of the same rank.
            return HIGH_CARD;

        }

    }

    /**
     * This would be private, only for use by getBestHand
     * But it is used extensively by the various unit tests so needs to be public currently
     *
     * @param cards A String desription of the card
     * @return a List<Card>
     */
    public static List<Card> getListOfCards(String cards) {

        String[] cardSymbols = cards.split(",");
        if (cardSymbols.length != 5) {
            throw new RuntimeException("symbols for 5 cards must be supplied.");
        }

        List<Card> listOfCards = new ArrayList<>();

        for (String cardSymbol : cardSymbols) {
            listOfCards.add(Card.buildFromShortCode(cardSymbol));

        }

        return listOfCards;

    }

}
