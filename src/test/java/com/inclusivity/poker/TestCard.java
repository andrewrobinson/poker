package com.inclusivity.poker;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestCard {

    @Test
    public void testBuildCardFromShortCode() {
//        "AS, 10C, 10H, 3D, 3S"

    }


    @Test
    public void testBuildCardFromRankCodeAndSuitCode() {
//        "AS, 10C, 10H, 3D, 3S"

        Card aceOfSpaces = new Card(Rank.ACE, Suit.SPADES);
        assertTrue(aceOfSpaces.equals(Card.buildFromRankCodeAndSuitCode("A", "S")));

        Card tenOfClubs = new Card(Rank.TEN, Suit.CLUBS);
        assertTrue(tenOfClubs.equals(Card.buildFromRankCodeAndSuitCode("10", "C")));

        Card tenOfHearts = new Card(Rank.TEN, Suit.HEARTS);
        assertTrue(tenOfHearts.equals(Card.buildFromRankCodeAndSuitCode("10", "H")));

        Card threeOfDiamonds = new Card(Rank.THREE, Suit.DIAMONDS);
        assertTrue(threeOfDiamonds.equals(Card.buildFromRankCodeAndSuitCode("3", "D")));

        Card threeOfSpades = new Card(Rank.THREE, Suit.SPADES);
        assertTrue(threeOfSpades.equals(Card.buildFromRankCodeAndSuitCode("3", "S")));


    }


}
