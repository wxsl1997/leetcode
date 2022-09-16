package org.wxsl.leetcode.offer.m2105w4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Offer51Test {

    @Test
    void primaryReversePairsTest() {
        int result = Offer51.primaryReversePairs(new int[]{7, 5, 6, 4});
        int expect = 5;
        Assertions.assertEquals(expect, result);
    }

    @Test
    void reversePairsTest() {
        int result = Offer51.reversePairs(new int[]{7, 5, 6, 4});
        int expect = 5;
        Assertions.assertEquals(expect, result);
    }
}