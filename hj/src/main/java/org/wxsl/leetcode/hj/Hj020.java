package org.wxsl.leetcode.hj;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author wxsl1997
 */
public class Hj020 {

    public static final Pattern LOWER_CASE_PATTERN_1 = Pattern.compile("[a-z]");
    public static final Pattern UPPER_CASE_PATTERN_1 = Pattern.compile("[A-Z]");
    public static final Pattern DIGIT_PATTERN_1 = Pattern.compile("[0-9]");
    public static final Pattern OTHER_PATTERN_1 = Pattern.compile("[^0-9A-Za-z]");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();


            boolean valid = valid(str);

            System.out.println(valid ? "OK" : "NG");
        }
    }

    private static boolean valid(String str) {

        if (str == null || str.length() <= 8) {
            return false;
        }

        for (int index = 0; index < str.length() - 3; index++) {
            String segment = str.substring(index, index + 3);
            // 存在重复子串情形
            if (str.substring(index + 3).contains(segment)) {
                return false;
            }
        }

        int type = 0;
        if (LOWER_CASE_PATTERN_1.matcher(str).find()) {
            type++;
        }
        if (UPPER_CASE_PATTERN_1.matcher(str).find()) {
            type++;
        }
        if (DIGIT_PATTERN_1.matcher(str).find()) {
            type++;
        }
        if (OTHER_PATTERN_1.matcher(str).find()) {
            type++;
        }

        return type >= 3;
    }
}
