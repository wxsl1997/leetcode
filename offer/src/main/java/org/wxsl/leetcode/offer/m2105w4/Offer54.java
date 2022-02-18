package org.wxsl.leetcode.offer.m2105w4;

/**
 * 二叉搜索树的第k大节点
 */
public class Offer54 {

    /**
     * 思路:利用类存储 第k大节点
     */
    static class Solution {
        int res, k;

        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res;
        }

        void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.right);
            if (k == 0) {
                return;
            }
            if (--k == 0) {
                res = root.val;
            }
            dfs(root.left);
        }
    }

    /**
     * 最初思路:中序遍历
     */
    public static int primaryKthLargest(TreeNode root, int k) {

        //使用数组暂存最大的几位数
        int[] trace = new int[k];

        primaryDfs(root, trace, 0, k);

        return trace[k - 1];
    }


    /**
     * 将最大的前 k 个元素装进 trace 数组
     *
     * @return 当前装载元素的个数
     */
    private static int primaryDfs(TreeNode root, int[] trace, int current, int total) {

        //遍历右边
        if (root.right != null) {
            current = primaryDfs(root.right, trace, current, total);
        }

        // 装载完毕, 无需后续操作
        if (current >= total) {
            return current;
        }

        //装载数据
        trace[current++] = root.val;

        //遍历右边
        if (root.left != null) {
            current = primaryDfs(root.left, trace, current, total);
        }

        return current;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
