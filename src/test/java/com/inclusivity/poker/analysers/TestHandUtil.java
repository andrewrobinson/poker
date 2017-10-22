package com.inclusivity.poker.analysers;

import com.inclusivity.poker.Hand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHandUtil {

    @Test
    public void testRankMatchingCount() {

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
