package org.wxsl.leetcode.offer.m2105w3;

/**
 * 反转链表
 */
public class Offer24 {


    public static ListNode reverseList(ListNode head) {

        ListNode result = null;

        for (ListNode current = head, node = current; current != null; current = node) {

            // node 记录 next node 位置
            node = node.next;

            // 当前 node 前置
            current.next = result;

            // result 前置
            result = current;
        }

        return result;
    }

    public static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
