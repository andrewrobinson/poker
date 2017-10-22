package com.inclusivity.poker;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestHand {

    @Test
    public void testGetListOfCards() {

        List<Card> listOfCards = Hand.getListOfCards("AS, 10C, 10H, 3D, 3S");

        assertEquals(5, listOfCards.size());

        assertTrue(TestCard.aceOfSpaces.equals(listOfCards.get(0)));
        assertTrue(TestCard.tenOfClubs.equals(listOfCards.get(1)));
        assertTrue(TestCard.tenOfHearts.equals(listOfCards.get(2)));
        assertTrue(TestCard.threeOfDiamonds.equals(listOfCards.get(3)));
        assertTrue(TestCard.threeOfSpades.equals(listOfCards.get(4)));


    }

    @Test
    public void testGetBestHand() {

        assertEquals("Two Pair", Hand.getBestHand("AS, 10C, 10H, 3D, 3S"));

    }

    @Test(expected = RuntimeException.class)
    public void testFewerThanFiveCards() {
        Hand.getBestHand("only, four, cards, supplied");
    }

    @Test(expected = RuntimeException.class)
    public void testMoreThanFiveCards() {
        Hand.getBestHand("now, six, cards, have, been, supplied");
    }

    @Test(expected = RuntimeException.class)
    public void testStringWithoutCommas() {
        Hand.getBestHand("no commas here");
    }

    @Test(expected = RuntimeException.class)
    public void testEmptyString() {
        Hand.getBestHand("");
    }

    @Test(expected = RuntimeException.class)
    public void testNullString() {
        Hand.getBestHand(null);
    }

}
