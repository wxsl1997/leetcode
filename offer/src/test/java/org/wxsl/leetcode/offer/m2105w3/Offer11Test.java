package org.wxsl.leetcode.offer.m2105w3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Offer11Test {

    @Test
    public void minArray() {
        Assertions.assertEquals(1, Offer11.minArray(new int[]{3, 4, 5, 1, 2}));
    }

    @Test
    public void primaryMinArray() {
        Assertions.assertEquals(1, Offer11.primaryMinArray(new int[]{3, 4, 5, 1, 2}));
    }
}