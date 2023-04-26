package org.wxsl.leetcode.hj;

import java.util.Scanner;

/**
 * @author wxsl1997
 */
public class Hj103 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int size = in.nextInt();

        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = in.nextInt();
        }

        int max = -1;

        int[] dp = new int[size];
        for (int i = 0; i < size; i++) {

            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}