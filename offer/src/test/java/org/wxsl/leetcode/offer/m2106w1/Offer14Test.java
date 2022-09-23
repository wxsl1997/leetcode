package org.wxsl.leetcode.offer.m2106w1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Offer14Test {

    @Test
    void cuttingRopeTest() {
        int result = Offer14.cuttingRope(10);
        int expect = 36;
        Assertions.assertEquals(expect, result);
    }

    @Test
    void primaryCuttingRopeTest() {
        int result = Offer14.primaryCuttingRope(10);
        int expect = 36;
        Assertions.assertEquals(expect, result);
    }
}