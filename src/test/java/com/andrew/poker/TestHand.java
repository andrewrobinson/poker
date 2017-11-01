package com.andrew.poker;

import org.junit.Test;

import java.util.List;

import static com.andrew.poker.Hand.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestHand {

    @Test
    public void testGetBestHand() {

        //Examples from https://en.wikipedia.org/wiki/List_of_poker_hands

        //0.five of a kind
        assertEquals(FIVE_OF_A_KIND, Hand.getBestHand("AS, AC, AH, AD, AS"));

        //1. Straight flush
        assertEquals(STRAIGHT_FLUSH, Hand.getBestHand("JC, 10C, 9C, 8C, 7C"));

        //2. Four of a kind
        assertEquals(FOUR_OF_A_KIND, Hand.getBestHand("5C, 5D, 5H, 5S, 2D"));

        //3. Full house
        assertEquals(FULL_HOUSE, Hand.getBestHand("6S, 6H, 6D, KC, KH"));

        //4. Flush
        assertEquals(FLUSH, Hand.getBestHand("JD, 9D, 8D, 4D, 3D"));

        //5. Straight
        assertEquals(STRAIGHT, Hand.getBestHand("10D, 9S, 8H, 7D, 6C"));

        //6. Three of a kind
        assertEquals(THREE_OF_A_KIND, Hand.getBestHand("QC, QS, QH, 9H, 2S"));

        //7. Two pair
        assertEquals(TWO_PAIR, Hand.getBestHand("JH, JS, 3C, 3S, 2H"));

        //8. One pair
        assertEquals(ONE_PAIR, Hand.getBestHand("10S, 10H, 8S, 7H, 4C"));

        //9. High Card
        assertEquals(HIGH_CARD, Hand.getBestHand("KD, QD, 7S, 4S, 3H"));


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


}
