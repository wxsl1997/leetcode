package org.wxsl.leetcode.hj;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author wxsl1997
 */
public class Hj002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 字符串
        char[] cs = in.nextLine().toLowerCase().toCharArray();

        // 目标字符
        String target = in.next().toLowerCase();

        // 出现次数计数器
        int count = 0;
        for (char c : cs) {
            if (Objects.equals(String.valueOf(c), target)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
