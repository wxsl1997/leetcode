package org.wxsl.leetcode.hj;

import java.util.Scanner;

/**
 * @author wxsl1997
 */
public class Hj032 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 接收控制台参数
        String str = in.nextLine();

        int[] dp = new int[str.length() + 1];
        // 动态规划
        for (int index = 0; index < str.toCharArray().length; index++) {
            dp[index + 1] = Math.max(dp[index], maxSymmetryNum(str, index));
        }


        System.out.println(dp[str.length()]);


    }

    private static int maxSymmetryNum(String str, int index) {

        int result = 1;


        char c = str.charAt(index);

        int current = str.indexOf(c);
        while (current < index) {

            boolean match = true;
            for (int begin = current + 1, end = index - 1; begin <= end; begin++, end--) {
                if (str.charAt(begin) != str.charAt(end)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                // 满足最大对称条件,直接返回
                return Math.max(index - current + 1, result);
            }

            current = str.indexOf(c, current + 1);
        }

        return result;
    }
}
