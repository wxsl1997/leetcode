package org.wxsl.leetcode.offer.m2105.w3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.wxsl.leetcode.offer.Constants;

class Offer38Test {

    public static final String MOCK_DATA = "mock";

    @RepeatedTest(Constants.TEST_COUNT)
    void permutation() {
        String[] results = Offer38.permutation(MOCK_DATA);
        Assertions.assertEquals(24, results.length);
    }

    @RepeatedTest(Constants.TEST_COUNT)
    void primaryPermutation() {
        String[] results = Offer38.primaryPermutation(MOCK_DATA);
        Assertions.assertEquals(24, results.length);
    }
}