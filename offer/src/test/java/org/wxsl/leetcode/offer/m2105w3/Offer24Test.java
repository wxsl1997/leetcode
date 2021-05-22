package org.wxsl.leetcode.offer.m2105w3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Offer24Test {

    @Test
    void reverseList() {

        Offer24.ListNode head = new Offer24.ListNode(1);
        Offer24.ListNode node2 = new Offer24.ListNode(2);
        Offer24.ListNode node3 = new Offer24.ListNode(3);
        Offer24.ListNode node4 = new Offer24.ListNode(4);
        Offer24.ListNode last = new Offer24.ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = last;

        Assertions.assertSame(last, Offer24.reverseList(head));
    }
}