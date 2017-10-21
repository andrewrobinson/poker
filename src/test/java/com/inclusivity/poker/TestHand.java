package com.inclusivity.poker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrew on 2017/10/21.
 */
public class TestHand {

    @Test
    public void testgetBestHand() {

        assertEquals("Two Pair", Hand.getBestHand("AS, 10C, 10H, 3D, 3S"));

    }

}
