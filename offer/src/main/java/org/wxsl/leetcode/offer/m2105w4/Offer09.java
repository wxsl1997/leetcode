package org.wxsl.leetcode.offer.m2105w4;

import java.util.LinkedList;
import java.util.Optional;

public class Offer09 {

    @SuppressWarnings({"AlibabaClassNamingShouldBeCamel", "unused"})
    public static class CQueue {

        LinkedList<Integer> data = new LinkedList<>();

        public void appendTail(int value) {
            data.offerLast(value);
        }

        public int deleteHead() {
            return Optional.ofNullable(data.poll()).orElse(-1);
        }
    }
}
