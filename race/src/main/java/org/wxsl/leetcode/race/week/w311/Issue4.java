package org.wxsl.leetcode.race.week.w311;

import java.util.Arrays;

public class Issue4 {

    /**
     * 思路:前缀数
     */
    public int[] sumPrefixScores(String[] words) {


        TreeNode root = new TreeNode();
        for (String word : words) {
            root.insert(word);
        }

        int[] result = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            result[i] = root.sumScore(words[i]);
        }

        return result;
    }

    private static class TreeNode {

        private static final int R = 26;

        private TreeNode[] children = new TreeNode[R];

        private int score = 0;

        public void insert(String word) {
            char[] chars = word.toCharArray();
            TreeNode current = this;
            for (char c : chars) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    // 首次装载
                    current.children[index] = new TreeNode();
                }
                // 节点转移
                current = current.children[index];
                // 访问次数 + 1
                current.score++;
            }
        }

        public int sumScore(String word) {
            char[] chars = word.toCharArray();

            int sum = 0;
            TreeNode current = this;
            for (char c : chars) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    // 结束
                    return sum;
                }
                // 节点转移
                current = current.children[index];
                // 累加次数
                sum += current.score;
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        Issue4 issue4 = new Issue4();
        issue4.sumPrefixScores(new String[]{"abc", "ab", "bc", "b"});
    }

    /**
     * 思路:暴力破解
     */
    public int[] primarySumPrefixScores(String[] words) {

        int[] result = new int[words.length];

        for (int n = 0; n < words.length; n++) {

            int count = 0;

            for (int i = 0; i < words[n].length(); i++) {
                String pre = words[n].substring(0, i + 1);

                count += Arrays.stream(words).filter(w -> w.startsWith(pre)).count();
            }
            result[n] = count;
        }

        return result;
    }
}
