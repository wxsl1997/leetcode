package org.wxsl.leetcode.offer.m2105w4;

public class Kmp {

    /**
     * @param source  主串
     * @param pattern 模式串
     * @return if substring exists  return the first occurrence index of pattern, else return -1
     */
    public static int indexOf(String source, String pattern) {

        char[] t = source.toCharArray();

        char[] p = pattern.toCharArray();

        // 主串位置
        int i = 0;
        // 模式串位置
        int j = 0;

        int[] next = getNext(pattern);

        while (i < t.length && j < p.length) {
            // 当j为-1时，要移动的是i，当然j也要归0
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else {
                // j回到指定位置
                j = next[j];
            }
        }

        return j == p.length ? i - j : -1;
    }

    public static int[] getNext(String ps) {

        char[] p = ps.toCharArray();

        int[] next = new int[p.length];

        // 当j=0时不匹配, 此时需要i指针后移
        next[0] = -1;

        int j = 0;

        int k = -1;

        while (j < p.length - 1) {

            if (k == -1 || p[j] == p[k]) {
                // next[j+1] == k + 1 == next[j] + 1
                ++k;
                ++j;
                next[j] = k;
            } else {
                // 尝试 在[0,k] 里面继续匹配
                k = next[k];
            }
        }
        return next;
    }
}
