package org.wxsl.leetcode.hj;

import java.util.Scanner;


/**
 * @author wxsl1997
 */
public class Hj067 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] nums = new int[4];
        nums[0] = in.nextInt();
        nums[1] = in.nextInt();
        nums[2] = in.nextInt();
        nums[3] = in.nextInt();

        // 标记是否访问
        int[] trades = new int[4];

        // 输出结果
        System.out.println(dfs(nums, trades, 0, 24));
    }

    private static boolean dfs(int[] nums, int[] trades, int current, int expect) {

        boolean allVisit = trades[0] == 1 && trades[1] == 1 && trades[2] == 1 && trades[3] == 1;

        // 结束标识
        if (current == expect && allVisit) {
            return true;
        }

        for (int index = 0; index < nums.length; index++) {

            if (trades[index] == 1) {
                continue;
            }

            // 标记已访问
            trades[index] = 1;

            boolean valid = dfs(nums, trades, current + nums[index], expect)
                    || dfs(nums, trades, current - nums[index], expect)
                    || dfs(nums, trades, current * nums[index], expect)
                    || (current % nums[index] == 0 && dfs(nums, trades, current / nums[index], expect));

            if (valid) {
                return true;
            }

            // 移除访问标志
            trades[index] = 0;
        }
        return false;
    }
}
