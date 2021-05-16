package org.wxsl.leetcode.offer.m2105.w3;

import org.junit.jupiter.api.RepeatedTest;

import static org.wxsl.leetcode.offer.Constants.TEST_COUNT;

class Offer43Test {

    @RepeatedTest(TEST_COUNT)
    public void testPrimaryCountDigitOne() {
        int num = (int) (Math.random() * Integer.MAX_VALUE);
        System.out.println(Offer43.primaryCountDigitOne(num));
    }

    @RepeatedTest(TEST_COUNT)
    public void testCountDigitOne() {
        int num = (int) (Math.random() * Integer.MAX_VALUE);
        System.out.println(Offer43.countDigitOne(num));
    }
}