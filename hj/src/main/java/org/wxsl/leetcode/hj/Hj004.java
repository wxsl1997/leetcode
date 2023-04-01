package org.wxsl.leetcode.hj;

import java.util.Scanner;

/**
 * @author wxsl1997
 */
public class Hj004 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 接收控制台参数
        String str = in.nextLine();


        // 字符串数量
        double num = Math.ceil(str.length() / 8D);

        str += "00000000";
        for (int current = 0; current < num; current++) {
            System.out.println(str.substring(current * 8, current * 8 + 8));
        }
    }
}
