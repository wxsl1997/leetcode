package org.wxsl.leetcode.offer.m2105w4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Offer54Test {


    private static final int K = 1;

    Offer54.TreeNode node2 = new Offer54.TreeNode(2, null, null);
    Offer54.TreeNode node4 = new Offer54.TreeNode(4, null, null);
    Offer54.TreeNode node1 = new Offer54.TreeNode(1, null, node2);
    Offer54.TreeNode node3 = new Offer54.TreeNode(3, node1, node4);

    @Test
    void primaryKthLargest() {
        Assertions.assertEquals(node4.val, Offer54.primaryKthLargest(node3, K));
    }

    @Test
    void KthLargest() {
        Assertions.assertEquals(node4.val, new Offer54.Solution().kthLargest(node3, K));
    }
}