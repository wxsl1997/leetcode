package org.wxsl.leetcode.hj;

import java.util.Arrays;
import java.util.Scanner;


/**
 * @author wxsl1997
 */
public class Hj030 {


    private static final String HEX_DICT = "0 1 2 3 4 5 6 7 8 9 a b c d e f";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String str1 = in.next();
        String str2 = in.next();

        // 步骤 1
        String str = str1 + str2;

        // 步骤 2
        String result = convertForStep2(str);

        char[] cs = result.toCharArray();
        for (char c : cs) {

            // 步骤 3
            System.out.print(convertForStep3(c));
        }
    }

    private static String convertForStep2(String str) {
        String evenStr = str.replaceAll("(\\w)(\\w)", "$1");
        String oddStr = str.substring(1).replaceAll("(\\w)(\\w)", "$1");


        char[] evenCs = evenStr.toCharArray();
        char[] oddCs = oddStr.toCharArray();
        Arrays.sort(evenCs);
        Arrays.sort(oddCs);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            if (i % 2 == 0) {
                sb.append(evenCs[i / 2]);
            } else {
                sb.append(oddCs[i / 2]);
            }
        }

        return sb.toString();
    }

    private static char convertForStep3(char c) {

        boolean contains = HEX_DICT.contains(String.valueOf(c).toLowerCase());
        if (!contains) {
            return c;
        }

        if (c == '0') {
            return '0';
        }
        if (c == '1') {
            return '8';
        }
        if (c == '2') {
            return '4';
        }
        if (c == '3') {
            return 'C';
        }
        if (c == '4') {
            return '2';
        }
        if (c == '5') {
            return 'A';
        }
        if (c == '6') {
            return '6';
        }
        if (c == '7') {
            return 'E';
        }
        if (c == '8') {
            return '1';
        }
        if (c == '9') {
            return '9';
        }
        if (c == 'a' || c == 'A') {
            return '5';
        }
        if (c == 'b' || c == 'B') {
            return 'D';
        }
        if (c == 'c' || c == 'C') {
            return '3';
        }
        if (c == 'd' || c == 'D') {
            return 'B';
        }
        if (c == 'e' || c == 'E') {
            return '7';
        }
        if (c == 'f' || c == 'F') {
            return 'F';
        }
        return c;
    }
}
