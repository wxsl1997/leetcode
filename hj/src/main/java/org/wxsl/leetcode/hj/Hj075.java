package org.wxsl.leetcode.hj;



import java.util.Scanner;

public class Hj075 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str1 = in.nextLine();
        String str2 = in.nextLine();

        int[] dp = new int[str2.length() + 1];

        for (int i = 1; i < str2.length() + 1; i++) {
            dp[i] = dp[i - 1];
            for (int j = i; j > 0; j--) {
                if (str1.contains(str2.substring(i - j, i))) {
                    dp[i] = Math.max(j, dp[i]);
                }
            }
        }

        System.out.println(dp[str2.length()]);
    }
}