package org.wxsl.leetcode.offer.m2105w4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Offer09Test {

    @Test
    public void testDeque() {
        Offer09.CQueue cQueue = new Offer09.CQueue();
        int result = cQueue.deleteHead();
        int expect = -1;
        Assertions.assertEquals(expect, result);
    }
}