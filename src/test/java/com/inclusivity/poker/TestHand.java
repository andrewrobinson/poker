package com.inclusivity.poker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrew on 2017/10/21.
 */
public class TestHand {

    @Test
    public void testGetBestHand() {

        assertEquals("Two Pair", Hand.getBestHand("AS, 10C, 10H, 3D, 3S"));

    }

    @Test(expected=RuntimeException.class)
    public void testFewerThanFiveCards() {
        Hand.getBestHand("only, four, cards, supplied");
    }

    @Test(expected=RuntimeException.class)
    public void testMoreThanFiveCards() {
        Hand.getBestHand("now, six, cards, have, been, supplied");
    }

    @Test(expected=RuntimeException.class)
    public void testStringWithoutCommas() {
        Hand.getBestHand("no commas here");
    }

    @Test(expected=RuntimeException.class)
    public void testEmptyString() {
        Hand.getBestHand("");
    }

    @Test(expected=RuntimeException.class)
    public void testNullString() {
        Hand.getBestHand(null);
    }

}
