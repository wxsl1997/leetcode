package org.wxsl.leetcode.offer.m2105w3;

/**
 * 旋转数组的最小数字
 */
public class Offer11 {

    /**
     * 思路: pivot和high值比较缩减范围(循环)
     */
    public static int minArray(int[] numbers) {

        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            int pivot = low + (high - low) / 2;

            // 取右边
            if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            }
            // 取左边
            else if (numbers[pivot] < numbers[high]) {
                high = pivot;
            }
            // 丢弃 high
            else {
                high--;
            }
        }
        return numbers[low];
    }


    /**
     * 最初思路: startValue和endValue比较缩减范围(递归)
     */
    public static int primaryMinArray(int[] numbers) {

        int len = numbers.length;

        int startValue = numbers[0];
        int endValue = numbers[len - 1];

        if (len <= 2) {
            return Math.min(startValue, endValue);
        }

        // 直接得到目标值
        if (startValue < endValue) {
            return startValue;
        }
        // 丢弃endValue
        else if (startValue == endValue) {
            return primaryMinArray(subArray(numbers, 0, len - 1));
        }

        // startValue > endValue
        return startValue > numbers[numbers.length / 2]
                // 截取左边 [0, len/2]
                ? primaryMinArray(subArray(numbers, 0, len / 2 + 1))
                // 截取右边 [len/2 ,len)
                : primaryMinArray(subArray(numbers, len / 2, len));
    }

    /**
     * 截取组数
     *
     * @param numbers    源数组
     * @param startIndex 起始下标(开)
     * @param endIndex   终止下标(闭)
     * @return 截取后的新数组
     */
    private static int[] subArray(int[] numbers, int startIndex, int endIndex) {
        int[] result = new int[endIndex - startIndex];
        System.arraycopy(numbers, startIndex, result, 0, endIndex - startIndex);
        return result;
    }
}
