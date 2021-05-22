package org.wxsl.leetcode.offer.m2105w3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Offer19Test {

    @Test
    void isMatch() {
        boolean match = Offer19.isMatch("a", "ab*");
        Assertions.assertTrue(match);
    }

    @Test
    void primaryIsMatch() {
        boolean match = Offer19.primaryIsMatch("a", "ab*");
        Assertions.assertTrue(match);
    }
}