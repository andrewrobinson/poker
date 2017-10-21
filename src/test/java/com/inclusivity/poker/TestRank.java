package com.inclusivity.poker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestRank {

    @Test
    public void testBuildRankFromShortCode() {

        assertEquals(Rank.ACE, Rank.fromShortCode("A"));
        assertEquals(Rank.TWO, Rank.fromShortCode("2"));
        assertEquals(Rank.THREE, Rank.fromShortCode("3"));
        assertEquals(Rank.FOUR, Rank.fromShortCode("4"));
        assertEquals(Rank.FIVE, Rank.fromShortCode("5"));
        assertEquals(Rank.SIX, Rank.fromShortCode("6"));
        assertEquals(Rank.SEVEN, Rank.fromShortCode("7"));
        assertEquals(Rank.EIGHT, Rank.fromShortCode("8"));
        assertEquals(Rank.NINE, Rank.fromShortCode("9"));
        assertEquals(Rank.TEN, Rank.fromShortCode("10"));
        assertEquals(Rank.JACK, Rank.fromShortCode("J"));
        assertEquals(Rank.QUEEN, Rank.fromShortCode("Q"));
        assertEquals(Rank.KING, Rank.fromShortCode("K"));

        assertEquals(null, Rank.fromShortCode(null));
        assertEquals(null, Rank.fromShortCode(""));
        assertEquals(null, Rank.fromShortCode("something"));



    }
}
