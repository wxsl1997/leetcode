package org.wxsl.leetcode.hj;

import java.util.Scanner;

/**
 * @author wxsl1997
 */
public class Hj024 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        int[] heights = new int[num];

        for (int current = 0; current < num; current++) {
            heights[current] = in.nextInt();
        }

        int[] incrementHeights = new int[num];

        for (int i = 0; i < num; i++) {
            incrementHeights[i] = 1;

            //寻找最长递增
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    incrementHeights[i] = Math.max(incrementHeights[i], incrementHeights[j] + 1);
                }
            }
        }


        int[] decrementHeights = new int[num];
        for (int i = num - 1; i >= 0; i--) {
            decrementHeights[i] = 1;

            //寻找最长递减
            for (int j = i + 1; j < num; j++) {
                if (heights[j] < heights[i]) {
                    decrementHeights[i] = Math.max(decrementHeights[i], decrementHeights[j] + 1);
                }
            }
        }


        int queueNum = 0;
        for (int i = 0; i < num; i++) {
            // 转折点计算两次
            queueNum = Math.max(queueNum, incrementHeights[i] + decrementHeights[i] - 1);
        }

        System.out.println(num - queueNum);
    }
}
