package org.wxsl.leetcode.hj;

import java.util.Scanner;

/**
 * @author wxsl1997
 */
public class Hj005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();

            // 删除 0x 前缀
            str = str.substring(2);

            char[] cs = str.toLowerCase().toCharArray();

            int result = 0;

            for (char c : cs) {
                result = result * 16 + heToDe(c);
            }


            System.out.println(result);

        }
    }

    private static int heToDe(char hex) {
        switch (hex) {
            case '0': {
                return 0;
            }
            case '1': {
                return 1;
            }
            case '2': {
                return 2;
            }
            case '3': {
                return 3;
            }
            case '4': {
                return 4;
            }
            case '5': {
                return 5;
            }
            case '6': {
                return 6;
            }
            case '7': {
                return 7;
            }
            case '8': {
                return 8;
            }
            case '9': {
                return 9;
            }
            case 'a': {
                return 10;
            }
            case 'b': {
                return 11;
            }
            case 'c': {
                return 12;
            }
            case 'd': {
                return 13;
            }
            case 'e': {
                return 14;
            }
            case 'f': {
                return 15;
            }
            default: {
                throw new UnsupportedOperationException(String.format("not supported char hex to dex, char:%s", hex));
            }
        }
    }
}
