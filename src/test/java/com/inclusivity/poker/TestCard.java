package com.inclusivity.poker;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestCard {

    protected static Card aceOfSpaces = new Card(Rank.ACE, Suit.SPADES);
    protected static Card tenOfClubs = new Card(Rank.TEN, Suit.CLUBS);
    protected static Card tenOfHearts = new Card(Rank.TEN, Suit.HEARTS);
    protected static Card threeOfDiamonds = new Card(Rank.THREE, Suit.DIAMONDS);
    protected static Card threeOfSpades = new Card(Rank.THREE, Suit.SPADES);
    protected static Card jackOfHearts = new Card(Rank.JACK, Suit.HEARTS);

    @Test
    public void testBuildCardFromShortCode() {

        assertTrue(aceOfSpaces.equals(Card.buildFromShortCode("AS")));
        assertTrue(tenOfClubs.equals(Card.buildFromShortCode("10C")));
        assertTrue(tenOfHearts.equals(Card.buildFromShortCode("10H")));
        assertTrue(threeOfDiamonds.equals(Card.buildFromShortCode("3D")));
        assertTrue(threeOfSpades.equals(Card.buildFromShortCode("3S")));
        assertTrue(jackOfHearts.equals(Card.buildFromShortCode("JH")));

        //There shouldn't be anything extra after the rank and suit
        assertNull(Card.buildFromShortCode("JH1234"));

        assertNull(Card.buildFromShortCode(""));
        assertNull(Card.buildFromShortCode(null));
        assertNull(Card.buildFromShortCode("something"));


    }


    @Test
    public void testBuildCardFromRankCodeAndSuitCode() {

        assertTrue(aceOfSpaces.equals(Card.buildFromRankCodeAndSuitCode("A", "S")));
        assertTrue(tenOfClubs.equals(Card.buildFromRankCodeAndSuitCode("10", "C")));
        assertTrue(tenOfHearts.equals(Card.buildFromRankCodeAndSuitCode("10", "H")));
        assertTrue(threeOfDiamonds.equals(Card.buildFromRankCodeAndSuitCode("3", "D")));
        assertTrue(threeOfSpades.equals(Card.buildFromRankCodeAndSuitCode("3", "S")));

    }


}
