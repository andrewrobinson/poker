package com.inclusivity.poker.analysers;

import com.inclusivity.poker.Card;
import com.inclusivity.poker.Hand;
import com.inclusivity.poker.Rank;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestRankAnalyser {

    @Test
    public void testHasTripsAndAPair() {

        //Three Tens and two Threes
        List<Card> listOfCards = Hand.getListOfCards("3S, 10C, 10H, 10D, 3S");
        RankAnalyser rankAnalyser = new RankAnalyser(listOfCards);
        assertTrue(rankAnalyser.hasTripsAndAPair());

        //Two pairs
        listOfCards = Hand.getListOfCards("AS, 10C, 10H, 3D, 3S");
        rankAnalyser = new RankAnalyser(listOfCards);
        assertFalse(rankAnalyser.hasTripsAndAPair());

        //Four of a kind
        listOfCards = Hand.getListOfCards("10S, 10C, 10H, 10D, 3S");
        rankAnalyser = new RankAnalyser(listOfCards);
        assertFalse(rankAnalyser.hasTripsAndAPair());

    }

    @Test
    public void testHasFourOfAKind() {

        //The example from https://en.wikipedia.org/wiki/List_of_poker_hands
        List<Card> listOfCards = Hand.getListOfCards("5C, 5D, 5H, 5S, 2D");
        RankAnalyser rankAnalyser = new RankAnalyser(listOfCards);
        assertTrue(rankAnalyser.hasFourOfAKind());

        //Four tens
        listOfCards = Hand.getListOfCards("10S, 10C, 10H, 10D, 3S");
        rankAnalyser = new RankAnalyser(listOfCards);
        assertTrue(rankAnalyser.hasFourOfAKind());

        //Three Tens and two Threes (this is hasTripsAndAPair though)
        listOfCards = Hand.getListOfCards("3S, 10C, 10H, 10D, 3S");
        rankAnalyser = new RankAnalyser(listOfCards);
        assertFalse(rankAnalyser.hasFourOfAKind());

    }

    @Test
    public void testHasFiveOfAKind() {

        //The example from https://en.wikipedia.org/wiki/List_of_poker_hands
        //Wiki says Five of a kind is only possible when using one or more wild cards
        //So here a wildcard is used to make the second AS
        List<Card> listOfCards = Hand.getListOfCards("AS, AC, AH, AD, AS");
        RankAnalyser rankAnalyser = new RankAnalyser(listOfCards);
        assertTrue(rankAnalyser.hasFiveOfAKind());

        //The same but with 10s
        listOfCards = Hand.getListOfCards("10S, 10C, 10H, 10D, 10S");
        rankAnalyser = new RankAnalyser(listOfCards);
        assertTrue(rankAnalyser.hasFiveOfAKind());

        //Wildcard as 4D means no
        listOfCards = Hand.getListOfCards("AS, AC, AH, AD, 4D");
        rankAnalyser = new RankAnalyser(listOfCards);
        assertFalse(rankAnalyser.hasFiveOfAKind());

    }

    @Test
    public void testGetCountsPerRank() {

        List<Card> listOfCards = Hand.getListOfCards("AS, 10C, 10H, 3D, 3S");
        assertEquals(5, listOfCards.size());

        RankAnalyser rankAnalyser = new RankAnalyser(listOfCards);
        Map<Rank, Integer> countsPerRank = rankAnalyser.getCountsPerRank();

        assertEquals(2, (int) countsPerRank.get(Rank.TEN));
        assertEquals(2, (int) countsPerRank.get(Rank.THREE));
        assertEquals(1, (int) countsPerRank.get(Rank.ACE));
        assertEquals(null, countsPerRank.get(Rank.FIVE));

    }

}
