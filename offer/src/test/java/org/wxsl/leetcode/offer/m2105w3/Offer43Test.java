package org.wxsl.leetcode.offer.m2105w3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Offer43Test {

    @Test
    public void primaryCountDigitOne() {
        int result = Offer43.primaryCountDigitOne(12);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void countDigitOne() {
        int result = Offer43.countDigitOne(12);
        Assertions.assertEquals(5, result);
    }
}