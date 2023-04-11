package org.wxsl.leetcode.hj;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author wxsl1997
 */
public class Hj028 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        // 接收控制台参数
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = in.nextInt();
        }

        // 左边奇数
        List<Integer> leftNums = Arrays.stream(nums).filter(n -> n % 2 == 1).boxed().collect(Collectors.toList());
        // 右边偶数
        List<Integer> rightNums = Arrays.stream(nums).filter(n -> n % 2 == 0).boxed().collect(Collectors.toList());


        // 初始化边
        boolean[][] map = new boolean[leftNums.size()][rightNums.size()];
        for (int i = 0; i < leftNums.size(); i++) {
            for (int j = 0; j < rightNums.size(); j++) {
                map[i][j] = isPrime(leftNums.get(i) + rightNums.get(j));
            }
        }

        // 记录当前右侧元素所对应的左侧元素
        int[] matchedNums = new int[rightNums.size()];


        int result = 0;

        for (int leftIndex = 0; leftIndex < leftNums.size(); leftIndex++) {
            int[] visits = new int[rightNums.size()];
            boolean match = match(rightNums, matchedNums, visits, leftIndex, map);
            if (match) {

                result++;
            }
        }

        // 输出结果
        System.out.println(result);
    }

    private static boolean match(List<Integer> rightNums, int[] rightMatched, int[] visits, int leftIndex, boolean[][] map) {

        for (int rightIndex = 0; rightIndex < rightNums.size(); rightIndex++) {
            // 有边且未访问
            if (map[leftIndex][rightIndex] && visits[rightIndex] == 0) {

                // 记录状态为访问过
                visits[rightIndex] = 1;

                // 如果 rightIndex 暂无匹配, 或者原来匹配的左侧元素可以找到新的匹配
                if (rightMatched[rightIndex] == 0 || match(rightNums, rightMatched, visits, rightMatched[rightIndex], map)) {
                    rightMatched[rightIndex] = leftIndex;
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}