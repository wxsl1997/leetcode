package org.wxsl.leetcode.hj;

import java.util.Scanner;

/**
 * @author wxsl1997
 */
public class Hj029 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 原始字符串
        String row = in.nextLine();
        // 加密后的字符串
        String encode = in.nextLine();

        // 输出结果
        System.out.println(encodeWord(row));
        System.out.println(decodeWord(encode));

    }

    private static String encodeWord(String row) {

        char[] cs = row.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];

            cs[i] = encodeChar(c);
        }


        return String.valueOf(cs);
    }


    private static String decodeWord(String encode) {

        char[] cs = encode.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];

            cs[i] = decodeChar(c);
        }
        return String.valueOf(cs);
    }

    private static char encodeChar(char c) {
        // 小写 末位
        if (c == 'z') {
            return 'A';
        }
        // 大写 末位
        if (c == 'Z') {
            return 'a';
        }
        // 数字 末位
        if (c == '9') {
            return '0';
        }

        // 大写
        if (c >= 'A' && c <= 'Z') {
            c += 32;
            return (char) (c + 1);
        }
        // 小写
        else if (c >= 'a' && c <= 'z') {
            c -= 32;
            return (char) (c + 1);
        }

        // 数字
        if (c >= '0' && c <= '9') {
            return (char) (c + 1);
        }

        return c;
    }

    private static char decodeChar(char c) {

        // 小写 末位
        if (c == 'A') {
            return 'z';
        }
        // 大写 末位
        if (c == 'a') {
            return 'Z';
        }
        // 数字 末位
        if (c == '0') {
            return '9';
        }

        // 大写
        if (c >= 'A' && c <= 'Z') {
            c += 32;
            return (char) (c - 1);
        }
        // 小写
        else if (c >= 'a' && c <= 'z') {
            c -= 32;
            return (char) (c - 1);
        }
        // 数字
        if (c >= '0' && c <= '9') {
            return (char) (c - 1);
        }

        return c;
    }
}
