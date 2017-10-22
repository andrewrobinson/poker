package com.inclusivity.poker.analysers;

import com.inclusivity.poker.Card;
import com.inclusivity.poker.Hand;
import com.inclusivity.poker.Rank;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestRankAnalyser {

    @Test
    public void testGetCountsPerRank() {

        List<Card> listOfCards = Hand.getListOfCards("AS, 10C, 10H, 3D, 3S");
        assertEquals(5, listOfCards.size());

        RankAnalyser rankAnalyser = new RankAnalyser(listOfCards);
        Map<Rank, Integer> countsPerRank = rankAnalyser.getCountsPerRank();

        assertEquals(2, (int) countsPerRank.get(Rank.TEN));
        assertEquals(2, (int) countsPerRank.get(Rank.THREE));
        assertEquals(1, (int) countsPerRank.get(Rank.ACE));
        assertEquals(null, countsPerRank.get(Rank.FIVE));


    }
}
