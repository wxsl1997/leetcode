package org.wxsl.leetcode.offer.m2105w4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Offer37Test {

    Offer37.TreeNode node8 = new Offer37.TreeNode(8, null, null);
    Offer37.TreeNode node7 = new Offer37.TreeNode(7, null, null);
    Offer37.TreeNode node6 = new Offer37.TreeNode(6, node8, null);
    Offer37.TreeNode node5 = new Offer37.TreeNode(5, null, node7);
    Offer37.TreeNode node4 = new Offer37.TreeNode(4, null, null);
    Offer37.TreeNode node3 = new Offer37.TreeNode(3, node5, node6);
    Offer37.TreeNode node2 = new Offer37.TreeNode(2, node4, null);
    Offer37.TreeNode node1 = new Offer37.TreeNode(1, node2, node3);

    @Test
    public void serializeTest() {

        Offer37.Codec codec = new Offer37.Codec();

        Offer37.TreeNode root = codec.deserialize(codec.serialize(node1));

        Assertions.assertEquals(codec.serialize(node1), codec.serialize(root));
    }
}