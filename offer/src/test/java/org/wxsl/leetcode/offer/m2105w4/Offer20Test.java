package org.wxsl.leetcode.offer.m2105w4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Offer20Test {

    @Test
    void primaryIsNumber() {
        boolean result = Offer20.primaryIsNumber("1");
        Assertions.assertTrue(result);
    }

    @Test
    void isNumber() {
        boolean result = Offer20.isNumber("1");
        Assertions.assertTrue(result);
    }
}