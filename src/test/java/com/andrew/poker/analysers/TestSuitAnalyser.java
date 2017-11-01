package com.andrew.poker.analysers;

import com.andrew.poker.Card;
import com.andrew.poker.Hand;
import com.andrew.poker.Suit;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestSuitAnalyser {


    @Test
    public void testHasAllCardsOfTheSameSuit() {

        List<Card> listOfCards = Hand.getListOfCards("AS, 10C, 10H, 3D, 3S");
        SuitAnalyser suitAnalyser = new SuitAnalyser(listOfCards);
        assertFalse(suitAnalyser.hasAllCardsOfTheSameSuit());

        //All Spades
        listOfCards = Hand.getListOfCards("AS, 10S, 9S, 3S, 3S");
        suitAnalyser = new SuitAnalyser(listOfCards);
        assertTrue(suitAnalyser.hasAllCardsOfTheSameSuit());

        //All Clubs
        listOfCards = Hand.getListOfCards("AC, 10C, 9C, 3C, 3C");
        suitAnalyser = new SuitAnalyser(listOfCards);
        assertTrue(suitAnalyser.hasAllCardsOfTheSameSuit());

        //All Diamonds
        listOfCards = Hand.getListOfCards("AD, 10D, 9D, 3D, 3D");
        suitAnalyser = new SuitAnalyser(listOfCards);
        assertTrue(suitAnalyser.hasAllCardsOfTheSameSuit());

        //All Hearts
        listOfCards = Hand.getListOfCards("AH, 10H, 9H, 3H, 3H");
        suitAnalyser = new SuitAnalyser(listOfCards);
        assertTrue(suitAnalyser.hasAllCardsOfTheSameSuit());

        //Hearts and one Club
        listOfCards = Hand.getListOfCards("AH, 10H, 9C, 3H, 3H");
        suitAnalyser = new SuitAnalyser(listOfCards);
        assertFalse(suitAnalyser.hasAllCardsOfTheSameSuit());

    }

    @Test
    public void testBuildUpSuitCountsPerSuitViaConstructor() {

        List<Card> listOfCards = Hand.getListOfCards("AS, 10C, 10H, 3D, 3S");
        assertEquals(5, listOfCards.size());

        SuitAnalyser suitAnalyser = new SuitAnalyser(listOfCards);
        Map<Suit, Integer> countsPerSuit = suitAnalyser.getCountsPerSuit();

        assertEquals(2, (int) countsPerSuit.get(Suit.SPADES));
        assertEquals(1, (int) countsPerSuit.get(Suit.CLUBS));
        assertEquals(1, (int) countsPerSuit.get(Suit.HEARTS));
        assertEquals(1, (int) countsPerSuit.get(Suit.DIAMONDS));


        //Now make it 3 spades and no diamonds
        listOfCards = Hand.getListOfCards("AS, 10C, 10H, 4S, 3S");
        assertEquals(5, listOfCards.size());

        suitAnalyser = new SuitAnalyser(listOfCards);
        countsPerSuit = suitAnalyser.getCountsPerSuit();

        assertEquals(3, (int) countsPerSuit.get(Suit.SPADES));
        assertEquals(1, (int) countsPerSuit.get(Suit.CLUBS));
        assertEquals(1, (int) countsPerSuit.get(Suit.HEARTS));
        assertEquals(null, countsPerSuit.get(Suit.DIAMONDS));

    }
}
