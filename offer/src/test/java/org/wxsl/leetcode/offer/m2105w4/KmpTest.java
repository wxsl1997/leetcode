package org.wxsl.leetcode.offer.m2105w4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("SpellCheckingInspection")
class KmpTest {

    @Test
    void indexOf() {
        String source = "abcabcecabcdss";

        String p1 = "abcd";
        Assertions.assertEquals(8, Kmp.indexOf(source, p1));

        String p2 = "abcde";
        Assertions.assertEquals(-1, Kmp.indexOf(source, p2));
    }

    @Test
    void getNext() {
        String pattern = "abcabd";

        int[] next = Kmp.getNext(pattern);

        int[] expect = {-1, 0, 0, 0, 1, 2};

        Assertions.assertArrayEquals(expect, next);
    }
}