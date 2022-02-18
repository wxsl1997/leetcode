package org.wxsl.leetcode.offer.m2105w4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 */
public class Offer59 {

    /**
     * 思路:单调队列, 利用队列存储 index
     */
    @SuppressWarnings("ConstantConditions")
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }

        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        // 初始化队列
        for (int i = 0; i < k; ++i) {
            // 如果队列末端值小于当前值, 则直接移除, 剩余首端则是最大值 index
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // 当前值 index 插进队列
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            // 移动滑块
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            // 移除 index 未窗口中的值
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 装载 窗口中最大值
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }


    /**
     * 最初思路:找到数组指定区域的最大值即可
     */
    public static int[] primaryMaxSlidingWindow(int[] nums, int k) {

        int nLen = nums.length;

        if (nLen == 0) {
            return new int[nLen];
        }
        int[] result = new int[nLen - k + 1];

        for (int start = 0; start + k <= nLen; start++) {
            result[start] = findMaxValue(nums, start, start + k);
        }

        return result;
    }

    /**
     * 求出 max(nums.sub(start,end))
     */
    private static int findMaxValue(int[] nums, int start, int end) {
        int result = nums[start];
        for (int current = start; current < end; current++) {
            if (nums[current] > result) {
                result = nums[current];
            }
        }
        return result;
    }
}
