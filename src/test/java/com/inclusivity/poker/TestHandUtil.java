package com.inclusivity.poker;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestHandUtil {

    @Test
    public void testRankMatchingCount() {

//        TODO - what if we have 2 matching in one rank and 3 matching in another rank?

        //We have two 10s and two 3s
        assertEquals(2, HandUtil.rankMatchingCount(Hand.getListOfCards("AS, 10C, 10H, 3D, 3S")));

        //We have only two 10s now
        assertEquals(1, HandUtil.rankMatchingCount(Hand.getListOfCards("AS, 10C, 10H, 3D, 4S")));

        //We have no matching ranks now
        assertEquals(0, HandUtil.rankMatchingCount(Hand.getListOfCards("AS, 9C, 10H, 3D, 4S")));

        //We have two Aces
        assertEquals(1, HandUtil.rankMatchingCount(Hand.getListOfCards("AS, 9C, 10H, 3D, AD")));

        //We have four Aces
        assertEquals(1, HandUtil.rankMatchingCount(Hand.getListOfCards("AS, AC, AH, 3D, AD")));


    }

}
