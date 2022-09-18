package org.wxsl.leetcode.offer.m2105w4;

import java.util.PriorityQueue;

public class Offer41 {

    public static class MedianFinder {

        // 大顶堆
        PriorityQueue<Integer> queMin = new PriorityQueue<>((a, b) -> (b - a));

        // 小顶堆
        PriorityQueue<Integer> queMax = new PriorityQueue<>();

        public void addNum(int num) {

            if (queMin.isEmpty()) {
                queMin.offer(num);
                return;
            }

            if (num <= queMin.peek()) {
                queMin.offer(num);
                // 堆转移
                if (queMax.size() + 1 < queMin.size()) {
                    queMax.offer(queMin.poll());
                }
            } else {
                queMax.offer(num);
                // 堆转移
                if (queMax.size() > queMin.size()) {
                    queMin.offer(queMax.poll());
                }
            }
        }

        public double findMedian() {
            if (queMin.size() > queMax.size()) {
                return queMin.peek();
            }
            //noinspection ConstantConditions
            return (queMin.peek() + queMax.peek()) / 2.0;
        }
    }
}
