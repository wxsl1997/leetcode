package org.wxsl.leetcode.hj;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author wxsl1997
 */
public class Hj003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 接收控制台参数
        int count = in.nextInt();
        int[] nums = new int[count];
        for (int current = 0; current < count; current++) {
            nums[current] = in.nextInt();
        }

        // 优先级队列
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            boolean exits = queue.contains(num);
            if (!exits) {
                queue.add(num);
            }
        }

        int queueSize = queue.size();
        //  for each 无法保证顺序, 需要循环 poll,
        for (int current = 0; current < queueSize; current++) {
            System.out.println(queue.poll());
        }
    }
}
