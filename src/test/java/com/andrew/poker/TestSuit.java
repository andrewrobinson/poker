package com.andrew.poker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSuit {

    @Test
    public void testBuildRankFromShortCode() {

        assertEquals(Suit.CLUBS, Suit.fromShortCode("C"));
        assertEquals(Suit.DIAMONDS, Suit.fromShortCode("D"));
        assertEquals(Suit.HEARTS, Suit.fromShortCode("H"));
        assertEquals(Suit.SPADES, Suit.fromShortCode("S"));

        assertEquals(null, Suit.fromShortCode(null));
        assertEquals(null, Suit.fromShortCode(""));
        assertEquals(null, Suit.fromShortCode("something"));

    }

}
