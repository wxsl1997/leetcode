package org.wxsl.leetcode.offer.m2105w3;

/**
 * 包含min函数的栈
 */
public class Offer30 {

    /**
     * 思路: node:{data,min,next}
     */
    public static class MinStack {

        private Node node;

        public MinStack() {

        }

        public void push(int x) {
            if (node == null) {
                node = new Node(x, x, null);
            } else {
                node = new Node(x, Math.min(x, node.min), node);
            }
        }

        public void pop() {
            node = node.next;
        }

        public int top() {
            return node.data;
        }

        public int min() {
            return node.min;
        }

        private static class Node {

            int data;

            int min;

            Node next;

            public Node(int data, int min, Node next) {
                this.data = data;
                this.min = min;
                this.next = next;
            }
        }
    }
}
