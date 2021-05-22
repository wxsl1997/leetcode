package org.wxsl.leetcode.offer.m2105w3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Offer30Test {

    @Test
    public void minStack() {
        Offer30.MinStack minStack = new Offer30.MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        Assertions.assertEquals(-3, minStack.min());

        minStack.pop();

        Assertions.assertEquals(0, minStack.top());
        Assertions.assertEquals(-2, minStack.min());
    }
}