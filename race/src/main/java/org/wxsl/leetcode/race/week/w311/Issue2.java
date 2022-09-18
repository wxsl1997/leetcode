package org.wxsl.leetcode.race.week.w311;

public class Issue2 {

    public int longestContinuousSubstring(String s) {

        char[] chars = s.toCharArray();

        int max = 1;

        int current = 1;
        for (int i = 0; i < chars.length - 1; i++) {

            if (chars[i + 1] - chars[i] == 1) {
                current++;
            } else {
                current = 1;
            }
            if (current > max) {
                max = current;
            }
        }
        return max;
    }
}
