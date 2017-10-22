package com.inclusivity.poker.analysers;

import com.inclusivity.poker.Card;
import com.inclusivity.poker.Hand;
import com.inclusivity.poker.Rank;
import com.inclusivity.poker.Suit;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestSuitAnalyser {

    @Test
    public void testGetCountsPerSuit() {

        List<Card> listOfCards = Hand.getListOfCards("AS, 10C, 10H, 3D, 3S");
        assertEquals(5, listOfCards.size());

        SuitAnalyser suitAnalyser = new SuitAnalyser(listOfCards);
        Map<Suit, Integer> countsPerSuit = suitAnalyser.getCountsPerSuit();

        assertEquals(2, (int) countsPerSuit.get(Suit.SPADES));
        assertEquals(1, (int) countsPerSuit.get(Suit.CLUBS));
        assertEquals(1, (int) countsPerSuit.get(Suit.HEARTS));
        assertEquals(1, (int) countsPerSuit.get(Suit.DIAMONDS));



    }
}
