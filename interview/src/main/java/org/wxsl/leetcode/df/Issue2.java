package org.wxsl.leetcode.df;

/**
 * @author wxsl1997
 */
public class Issue2 {

    public static void main(String[] args) {
        int m = 5;
        int n = 4;

        int blockX = 3;
        int blockY = 2;

        int[][] dp = dp(m, n, blockX, blockY);
        System.out.println(dp[m][n]);

        int result = dpWithLowerSpace(m, n, blockX, blockY);
        System.out.println(result);
    }

    private static int dpWithLowerSpace(int m, int n, int blockX, int blockY) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < m + 1; i++) {
            dp[0] = 1;
            for (int j = 1; j < n + 1; j++) {
                if (j == blockY && i == blockX) {
                    dp[j] = 0;
                } else {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[n];
    }


    private static int[][] dp(int m, int n, int blockX, int blockY) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == blockX && j == blockY) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp;
    }

    private static int dfs(int blockX, int blockY, int i, int j) {

        if (i == blockX && j == blockY) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 0;
        }

        if (i == 0 || j == 0) {
            return 1;
        }

        return dfs(blockX, blockY, i - 1, j) + dfs(blockX, blockY, i, j - 1);
    }
}
