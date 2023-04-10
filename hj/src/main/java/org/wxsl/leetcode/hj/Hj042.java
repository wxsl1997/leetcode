package org.wxsl.leetcode.hj;

import java.util.Scanner;


/**
 * @author wxsl1997
 */
public class Hj042 {

    private static String[] oneNumEnglish = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static String[] tenNumEnglish = new String[]{"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static final long BILLION = 1_000_000_000;
    public static final long MILLION = 1_000_000;
    public static final long THOUSAND = 1_000;
    public static final long HUNDRED = 1_00;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {

            long left = Long.parseLong(in.nextLine().replaceAll(",", ""));

            StringBuilder result = new StringBuilder();

            long billionNum = left / BILLION;
            if (billionNum >= 1) {
                left %= BILLION;
                String englishNum = toEnglish(billionNum);
                result.append(englishNum).append(" billion ");
            }

            long millionNum = left / MILLION;
            if (millionNum >= 1) {
                left %= MILLION;
                String englishNum = toEnglish(millionNum);
                result.append(englishNum).append(" million ");
            }

            long thousandNum = left / THOUSAND;
            if (thousandNum >= 1) {
                left %= THOUSAND;
                String englishNum = toEnglish(thousandNum);
                result.append(englishNum).append(" thousand ");
            }

            if (left >= 1) {
                String englishNum = toEnglish(left);
                result.append(englishNum);
            }

            System.out.println(result.toString().replaceAll(" +", " ").trim());
        }
    }

    private static String toEnglish(long num) {

        String result = "";

        int hundredNum = (int) (num / HUNDRED);
        if (hundredNum >= 1) {
            result += oneNumEnglish[hundredNum] + " " + "hundred";
        }

        // 百十间需要 and 连接
        if (hundredNum >= 1 && num % HUNDRED >= 1) {
            result += " and";
        }

        long left = num % HUNDRED;
        // 大于等于 20
        if (left >= 20) {
            int tenNum = (int) (num % HUNDRED) / 10;
            result += " " + tenNumEnglish[tenNum];

            int oneNum = (int) (num % 10);
            if (oneNum >= 1) {
                result += " " + oneNumEnglish[oneNum];
            }
        }
        // 小于 20
        else {
            int oneNum = (int) (num % 20);
            if (oneNum >= 1) {
                result += " " + oneNumEnglish[oneNum];
            }

        }
        return result;
    }
}
