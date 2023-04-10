package org.wxsl.leetcode.hj;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author wxsl1997
 */
public class Hj093 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        int sum = 0;

        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = in.nextInt();
            sum += nums[i];
        }

        // 要求和是2的倍数
        if (sum % 2 != 0) {
            System.out.println(false);
            return;
        }

        // 3的倍数那组需要从自由数据取的数值
        int target = sum / 2 - Arrays.stream(nums).filter(num -> num % 3 == 0).sum();

        // 自由选的数值
        List<Integer> libertyNums = Arrays.stream(nums).filter(num -> num % 5 != 0 && num % 3 != 0).boxed().collect(Collectors.toList());


        int[] traces = new int[libertyNums.size()];
        boolean valid = dfs(libertyNums, traces, target, 0);
        System.out.println(valid);
    }

    private static boolean dfs(List<Integer> libertyNums, int[] traces, int target, int current) {

        if (target == current) {
            return true;
        }

        for (int i = 0; i < libertyNums.size(); i++) {
            if (traces[i] == 1) {
                continue;
            }

            traces[i] = 1;
            boolean valid = dfs(libertyNums, traces, target, current + libertyNums.get(i));
            if (valid) {
                return true;
            }
            traces[i] = 0;
        }
        return false;
    }
}