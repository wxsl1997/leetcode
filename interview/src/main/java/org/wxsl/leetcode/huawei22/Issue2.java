package org.wxsl.leetcode.huawei22;

import java.util.Scanner;

public class Issue2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] nums = s.split(" +");
        int len = nums.length;

        int stepLen = len / 2;

        int minStepNum = len;

        for (int firstStepLen = stepLen; firstStepLen > 0; firstStepLen--) {
            int step = 1;

            int nextStepLen = Integer.parseInt(nums[firstStepLen]);
            int current = firstStepLen;

            while (nextStepLen + current < len) {
                step++;
                nextStepLen = Integer.parseInt(nums[current + nextStepLen]);
                current += nextStepLen;

                if (current == len - 1 && minStepNum > step) {
                    minStepNum = step;
                }
            }
        }

        if (minStepNum == len) {
            System.out.println(-1);
        } else {
            System.out.println(minStepNum);
        }
    }

}
