package org.wxsl.leetcode.offer.m2105w3;

/**
 * 二叉搜索树与双向链表
 */
public class Offer36 {

    /**
     * 思路:递归left和right, 然后与root合并即可
     */
    public static Node treeToDoublyList(Node root) {

        if (root == null) {
            return null;
        }

        //接左边,并确认最左边的节点
        Node leftHead = treeToDoublyList(root.left);
        Node leftestNode = leftHead == null ? root : leftHead;
        if (leftHead != null) {
            root.left = leftHead.left;
            leftHead.left.right = root;
        }

        //接右边,并确认最右边的节点
        Node rightHead = treeToDoublyList(root.right);
        Node rightestNode = rightHead == null ? root : rightHead.left;
        if (rightHead != null) {
            root.right = rightHead;
            rightHead.left = root;
        }

        //循环链表
        leftestNode.left = rightestNode;
        rightestNode.right = leftestNode;
        return leftestNode;
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}
