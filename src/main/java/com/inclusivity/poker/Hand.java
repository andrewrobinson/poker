package com.inclusivity.poker;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of cards described by symbols in a comma-separated string, identify the best poker hand in it
 * <p>
 * NB - I have not ensured that the list of cards does not contain duplicates not possible in a normal pack
 */
public class Hand {

    public static String getBestHand(String cards) {

        String[] cardSymbols = cards.split(",");
        if (cardSymbols.length != 5) {
            throw new RuntimeException("symbols for 5 cards must be supplied.");
        }

        List<Card> listOfCards = getListOfCards(cards);
        return getBestHandFromListOfCards(listOfCards);

    }


    private static String getBestHandFromListOfCards(List<Card> listOfCards) {


//        Unique fns:
//
//
//        a) rank_matching_count (5 or 4 or 3 or 2 are of interest and
//                sometimes all cards supplied and sometimes 3 or 2 of the  remaining
//                cards)
//
//        5 for all cards (has_five_of_a_kind)
//                4 for all cards (has_four_of_a_kind)
//                3 for all cards (has_trips)
//                2 for all cards (has_pair)
//                2 for remaining 2 cards (part of has_full_house, also needs has_trips)
//        2 for remaining 3 cards (has_another_pair)
//
//
//        b) suit_matching_count (5 is of interest for all cards only)
//        part of requirements for has_straight_flush
//
//
//        c) sequential_rank_count(5 is of interest for all cards only)
//        part of requirements for has_straight_flush
//
//        Derived fns:
//
//
//        has_five_of_a_kind = rank_matching_count(all_cards) == 5
//        has_straight_flush = (sequential_rank_count(all_cards) ==5) AND
//                (suit_matching_count(all_cards) ==5)
//        has_four_of_a_kind = (rank_matching_count(all_cards) == 4)
//        has_full_house = has_trips AND rank_matching_count(remaining_two_cards) == 2)
//        has_flush = (suit_matching_count(all_cards) ==5)
//        has_straight = (sequential_rank_count(all_cards) ==5) AND !
//                (suit_matching_count(all_cards) ==5)
//        has_trips = (rank_matching_count(all_cards) == 3)
//        has_another_pair = (rank_matching_count(3_remaining_cards) == 2)
//        has_pair = (rank_matching_count(all_cards) == 2)


        return "Two Pair";
    }

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
