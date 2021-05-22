package org.wxsl.leetcode.offer.m2105w3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Offer38Test {

    public static final String MOCK_DATA = "mock";

    @Test
    void permutation() {
        String[] results = Offer38.permutation(MOCK_DATA);
        Assertions.assertEquals(24, results.length);
    }

    @Test
    void primaryPermutation() {
        String[] results = Offer38.primaryPermutation(MOCK_DATA);
        Assertions.assertEquals(24, results.length);
    }
}