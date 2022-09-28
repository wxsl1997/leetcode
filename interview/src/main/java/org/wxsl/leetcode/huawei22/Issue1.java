package org.wxsl.leetcode.huawei22;

public class Issue1 {

    public static void main(String[] args) {
        int len = 3;
        int[][] nums = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                nums[i][j] = (int) (Math.random() * 100);
            }
        }

        int dfs = dfs(nums, 0, -1);

        System.out.println(dfs);
    }

    private static int dfs(int[][] nums, int level, int exclude) {

        if (level == nums.length) {
            return 0;
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (i == exclude) {
                continue;
            }

            int min = nums[level][i] + dfs(nums, level + 1, i);
            if (result > min) {
                result = min;
            }

        }
        return result;
    }
}
