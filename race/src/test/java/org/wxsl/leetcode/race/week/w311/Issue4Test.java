package org.wxsl.leetcode.race.week.w311;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Issue4Test {

    @Test
    public void sumPrefixScoresTest() {
        Issue4 issue4 = new Issue4();
        int[] result = issue4.sumPrefixScores(new String[]{"abc", "ab", "bc", "b"});
        int[] expect = new int[]{5, 4, 3, 2};
        Assertions.assertArrayEquals(expect, result);
    }

    @Test
    public void primarySumPrefixScoresTest() {
        Issue4 issue4 = new Issue4();
        int[] result = issue4.primarySumPrefixScores(new String[]{"abc", "ab", "bc", "b"});
        int[] expect = new int[]{5, 4, 3, 2};
        Assertions.assertArrayEquals(expect, result);
    }
}