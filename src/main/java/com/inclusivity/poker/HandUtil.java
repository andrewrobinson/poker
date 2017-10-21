package com.inclusivity.poker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HandUtil {

    //These are the fundamental 3 functions needed

    /**
     * This lets you know if there are any cards with matching rank in the list
     *
     * @param listOfCards
     *
     * @return the number of ranks where more than one instance of that rank is found in the list of cards
     */
    public static int rankMatchingCount(List<Card> listOfCards) {

        int rankMatchingCount = 0;

        Map<Rank, Integer> rankCounts = new HashMap<>();

        //We build up a list of counts per Rank
        for (Card card: listOfCards) {
            if (rankCounts.containsKey(card.getRank())) {
                Integer currentCount = rankCounts.get(card.getRank());
                rankCounts.put(card.getRank(), currentCount+1);
            } else {
                rankCounts.put(card.getRank(), 1);
            }

        }

        Set<Rank> ranksFound = rankCounts.keySet();

        //For any Rank that has a count more than one, we increment our counter
        for (Rank rank: ranksFound) {
            if (rankCounts.get(rank) > 1) {
                rankMatchingCount += 1;
            }

        }

        return rankMatchingCount;
    }

    /**
     * This lets you know if there are any matching suits in the list of cards
     *
     *
     * @param listOfCards
     * @return
     */
    public static int suitMatchingCount(List<Card> listOfCards) {

        return 0;
    }

    /**
     * This lets you know if there are any sequential ranks in the list of cards
     *
     * @param listOfCards
     * @return the number of sequential ranks in the list of cards
     */
    public static int sequentialRankCount(List<Card> listOfCards) {

        return 0;
    }



}
