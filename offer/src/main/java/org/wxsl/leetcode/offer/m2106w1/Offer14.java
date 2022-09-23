package org.wxsl.leetcode.offer.m2106w1;

public class Offer14 {


    public static int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                // 状态转移方程
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    public static int primaryCuttingRope(int n) {
        // 根据题意, n小于4的时候只会分成 1 和 n-1 两段
        if (n < 4) {
            return (n - 1);
        }

        int result = 1;

        int left = n;
        while (left > 0) {

            // 剩余长度小于4就没有必要再次切割, 否则切成长度是3的
            if (left > 4) {
                result *= 3;
                left -= 3;
            } else {
                // 无法切割的时候算上最后一段
                result *= left;
                left = 0;
            }
        }
        return result;
    }
}
