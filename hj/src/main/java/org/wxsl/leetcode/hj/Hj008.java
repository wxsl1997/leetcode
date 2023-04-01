package org.wxsl.leetcode.hj;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author wxsl1997
 */
public class Hj008 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        Map<Integer, Integer> result = new TreeMap<>();
        for (int current = 0; current < num; current++) {
            int key = in.nextInt();
            int value = in.nextInt();
            result.compute(key, (k, oldValue) -> Optional.ofNullable(oldValue).orElse(0) + value);
        }

        result.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
