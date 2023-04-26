package org.wxsl.leetcode.hj;

import java.util.Scanner;

public class Hj052 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str1 = in.nextLine();
        String str2 = in.nextLine();


        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];


        // 字符串str1从 空串变为字符串str2前j个字符 的莱文斯坦距离
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        // 字符串str1从 前i个字符变为空串 的莱文斯坦距离
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int countByInsert = dp[i][j - 1] + 1;
                int countByDel = dp[i - 1][j] + 1;
                int countByReplace = str1.charAt(i - 1) == str2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;

                dp[i][j] = Math.min(countByReplace, Math.min(countByInsert, countByDel));
            }
        }

        System.out.println(dp[m][n]);
    }
}