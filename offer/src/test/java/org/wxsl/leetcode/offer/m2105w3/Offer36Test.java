package org.wxsl.leetcode.offer.m2105w3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Offer36Test {

    @Test
    void treeToDoublyList() {
        Offer36.Node node1 = new Offer36.Node(1);
        Offer36.Node node2 = new Offer36.Node(2);
        Offer36.Node node3 = new Offer36.Node(3);
        Offer36.Node node4 = new Offer36.Node(4);
        Offer36.Node node5 = new Offer36.Node(5);

        node4.left = node2;
        node4.right = node5;

        node2.left = node1;
        node1.right = node3;

        Offer36.Node headNode = Offer36.treeToDoublyList(node4);

        // 最左节点
        Assertions.assertSame(node1, headNode);

        // 最右节点
        Assertions.assertSame(headNode.left, node5);
    }
}