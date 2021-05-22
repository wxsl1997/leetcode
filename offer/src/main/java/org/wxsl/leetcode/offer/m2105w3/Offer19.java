package org.wxsl.leetcode.offer.m2105w3;

/**
 * 正则表达式匹配
 */
public class Offer19 {

    private static final char DOT = '.';

    private static final char STAR = '*';

    /**
     * 思路:确定动态规划状态转移方程式
     */
    public static boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        //f[i][j] 表示 s 的前 i 个字符与 p 中的前 j 个字符是否能够匹配
        boolean[][] f = new boolean[sLen + 1][pLen + 1];

        //两个空字符串情形
        f[0][0] = true;

        for (int mIndex = 0; mIndex <= sLen; ++mIndex) {
            for (int nIndex = 1; nIndex <= pLen; ++nIndex) {

                // p[nIndex-1]为 '*' 情形
                if (p.charAt(nIndex - 1) == STAR) {
                    //丢弃 reg* 情形
                    f[mIndex][nIndex] = f[mIndex][nIndex - 2];

                    //如果s[mIndex-1] match p[nIndex-2],考虑 reg+ 组合情形
                    if (matches(s, p, mIndex - 1, nIndex - 2)) {
                        //丢弃 reg* 或者丢弃 s[mIndex-1]
                        f[mIndex][nIndex] = f[mIndex][nIndex] || f[mIndex - 1][nIndex];
                    }
                }
                // 如果 s[mIndex-1] match p[nIndex-1] 则看 前面的部分
                else if (matches(s, p, mIndex - 1, nIndex - 1)) {
                    f[mIndex][nIndex] = f[mIndex - 1][nIndex - 1];
                }
            }
        }
        return f[sLen][pLen];
    }

    /**
     * whether s[sIndex] matches p[pIndex]
     */
    private static boolean matches(String s, String p, int sIndex, int pIndex) {

        if (sIndex < 0) {
            return false;
        }

        if (p.charAt(pIndex) == DOT) {
            return true;
        }

        return s.charAt(sIndex) == p.charAt(pIndex);
    }

    /**
     * 初始思路:回溯算法
     */
    public static boolean primaryIsMatch(String s, String p) {

        return dfs(s, p, 0, 0);
    }

    private static boolean dfs(String s, String p, int sIndex, int pIndex) {

        int sLen = s.length();

        int pLen = p.length();

        if (pIndex == pLen) {
            // 探索终点
            return sIndex == sLen;
        }

        for (int index = sIndex; index <= sLen && pIndex < pLen; index++) {
            char reg = p.charAt(pIndex);
            boolean isStart = pIndex < pLen - 1 && p.charAt(pIndex + 1) == STAR;

            // 'reg*' 匹配条件
            if (isStart) {
                boolean match = matches(reg, s, sIndex, index) && dfs(s, p, index, pIndex + 2);
                if (match) {
                    return true;
                }
            }
            // 探索失败情形
            else if (sIndex == sLen) {
                return false;

            }
            // 'reg' 匹配条件
            else {
                return matches(reg, s, sIndex, index + 1) && dfs(s, p, index + 1, pIndex + 1);
            }
        }

        return false;
    }

    /**
     * whether s.sub(start, end) matches reg{sEnd-sStart}
     */
    private static boolean matches(char reg, String s, int sStart, int sEnd) {
        if (reg == DOT) {
            return true;
        }

        for (int index = sStart; index < sEnd; index++) {
            if (s.charAt(index) != reg) {
                return false;
            }
        }

        return true;
    }
}
