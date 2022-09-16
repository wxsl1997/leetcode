package org.wxsl.leetcode.offer.m2105w4;

/**
 * 数组中的逆序对
 */
public class Offer51 {

    /**
     * 思路:暴力破解
     */
    public static int primaryReversePairs(int[] nums) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    sum++;
                }
            }
        }
        return sum;
    }

    /**
     * 思路:归并排序
     */
    public static int reversePairs(int[] nums) {

        int len = nums.length;

        if (len <= 1) {
            return 0;
        }

        int[] copy = new int[len];
        System.arraycopy(nums, 0, copy, 0, len);

        int[] assists = new int[len];
        return merge(copy, 0, len, assists);
    }

    private static int merge(int[] nums, int start, int end, int[] assists) {

        int eleNum = end - start;
        if (eleNum == 1) {
            return 0;
        }

        int mid = (start + end) / 2;

        int leftCount = merge(nums, start, mid, assists);
        int rightCount = merge(nums, mid, end, assists);

        return leftCount + rightCount + mergeAndCount(nums, start, mid, end, assists);
    }

    private static int mergeAndCount(int[] nums, int start, int mid, int end, int[] assists) {
        if (end + 1 - start >= 0) {
            System.arraycopy(nums, start, assists, start, end - start);
        }

        int i = start;
        int j = mid;

        int count = 0;
        for (int k = start; k < end; k++) {
            // 剩余右边
            if (i == mid) {
                System.arraycopy(assists, j, nums, k, end - j);
                break;
            }
            // 剩余左边
            else if (j == end) {
                System.arraycopy(assists, i, nums, k, mid - i);
                break;
            }
            // 左边前进
            else if (assists[i] <= assists[j]) {
                nums[k] = assists[i];
                i++;
            }
            // 右边前进
            else {
                nums[k] = assists[j];
                j++;
                //累计计数
                count += (mid - i);
            }
        }
        return count;
    }
}
