package org.wxsl.leetcode.offer.m2105w4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Offer41Test {

    @Test
    public void findMedianTest() {
        Offer41.MedianFinder medianFinder = new Offer41.MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        medianFinder.addNum(-3);
        medianFinder.addNum(-4);

        double result = medianFinder.findMedian();
        Double expect = -2.5;
        Assertions.assertEquals(expect, result);
    }
}