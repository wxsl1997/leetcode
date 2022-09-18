package org.wxsl.leetcode.race.week.w311;

public class Issue3 {

    /**
     * 思路:中心对称 dfs
     */
    public TreeNode reverseOddLevels(TreeNode root) {
        int level = 1;
        dfs(root.left, root.right, level);
        return root;
    }

    private void dfs(TreeNode left, TreeNode right, int level) {
        if (left == null) {
            return;
        }
        // 交换数值
        if (level % 2 == 1) {
            int leftVal = left.val;
            left.val = right.val;
            right.val = leftVal;
        }

        int nextLevel = level + 1;
        // 中心对称
        dfs(left.left, right.right, nextLevel);
        dfs(left.right, right.left, nextLevel);
    }

    /**
     * 思路:翻转组合
     */
    public TreeNode primaryReverseOddLevels(TreeNode root) {
        // 翻转全部层
        TreeNode reverse = reverseLevels(root);

        int level = 0;
        // 翻转奇数层
        return reverseOdd(root, reverse, level);
    }

    private TreeNode reverseOdd(TreeNode root, TreeNode reverse, int level) {

        if (root == null) {
            return null;
        }

        // 偶数层 取 root 值, 奇数层 取 翻转后的值
        int val = level % 2 == 0 ? root.val : reverse.val;

        int nextLevel = level + 1;

        TreeNode copy = new TreeNode(val);
        copy.left = reverseOdd(root.left, reverse.left, nextLevel);
        copy.right = reverseOdd(root.right, reverse.right, nextLevel);
        return copy;
    }

    private TreeNode reverseLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode copy = new TreeNode(root.val);
        copy.left = reverseLevels(root.right);
        copy.right = reverseLevels(root.left);
        return copy;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
