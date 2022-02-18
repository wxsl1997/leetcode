package org.wxsl.leetcode.offer.m2105w4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Offer59Test {

    private int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};

    private int[] expect = {3, 3, 5, 5, 6, 7};

    @Test
    void maxSlidingWindow() {
        int[] result = Offer59.maxSlidingWindow(nums, 3);
        Assertions.assertArrayEquals(expect, result);
    }

    @Test
    void primaryMaxSlidingWindow() {
        int[] result = Offer59.primaryMaxSlidingWindow(nums, 3);
        Assertions.assertArrayEquals(expect, result);
    }
}