package org.wxsl.leetcode.offer.m2105.w3;

/**
 * 1～n 整数中 1 出现的次数
 */
public class Offer43 {

    /**
     * 思路: 统计位数上1出现次数
     */
    public static int countDigitOne(int n) {

        int result = 0;

        for (int ws = 1; n >= Math.pow(10, ws - 1); ws++) {

            int compareValue = (int) Math.pow(10, ws - 1);

            int currentNum = n / compareValue % 10;

            int highValue = n / compareValue / 10;

            int lowValue = n % compareValue;

            result = result + highValue * compareValue + Math.min(currentNum, 1) * (currentNum == 1 ? lowValue + 1 : compareValue);
        }

        return result;
    }

    /**
     * 最初思路: 2314 = 2000 + 200 + 10 + 4
     */
    public static int primaryCountDigitOne(int n) {

        int result = 0;

        for (int ws = 1; n >= Math.pow(10, ws - 1); ws++) {

            int factor = (int) Math.pow(10, ws - 1);

            int num = n / factor % 10;

            int mod = n % factor;

            result += countOneAmount(num, ws, mod);
        }
        return result;
    }

    private static int countOneAmount(int digit, int ws, int mod) {

        if (digit == 0) {
            return 0;
        }

        if (digit == 1) {
            return 1 + mod + countOneAmount(ws - 1);
        }

        return (int) (Math.pow(10, ws - 1) + digit * countOneAmount(ws - 1));
    }

    /**
     * @param ws 位数
     * @return 0~10^ws-1 里面出现 1 的数目
     */

    private static int countOneAmount(int ws) {

        if (ws < 1) {
            return 0;
        }

        return (int) (Math.pow(10, ws - 1) + 10 * countOneAmount(ws - 1));
    }
}
