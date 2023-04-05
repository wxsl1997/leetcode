package org.wxsl.leetcode.hj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @author wxsl1997
 */
public class Hj041 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 砝码种类 [1, 10]
        int typeNum = in.nextInt();

        // 接收砝码重量
        int[] wights = new int[typeNum];
        for (int index = 0; index < typeNum; index++) {
            wights[index] = in.nextInt();
        }

        // 接收砝码数量
        int[] nums = new int[typeNum];
        for (int index = 0; index < typeNum; index++) {
            int num = in.nextInt();
            nums[index] = num;
        }

        Set<Integer> results = new HashSet<>();
        results.add(0);

        for (int i = 0; i < wights.length; i++) {
            int wight = wights[i];
            for (int j = 0; j < nums[i]; j++) {
                results.addAll(results.stream().map(r -> r + wight).collect(Collectors.toSet()));
            }
        }

        System.out.println(results.size());
    }
}
