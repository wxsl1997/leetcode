package org.wxsl.leetcode.hj;

import java.util.*;


/**
 * @author wxsl1997
 */
public class Hj089 {

    public static final String JOKER = "joker";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 接收控制台参数
        String str = in.nextLine();

        boolean containJoker = str.toLowerCase().contains(JOKER);
        if (containJoker) {
            System.out.println("ERROR");
        } else {
            String[] cards = str.split(" ");

            int[] nums = convertToNums(cards);

            // 标记是否访问
            int[] visits = new int[4];

            for (int i = 0; i < nums.length; i++) {

                visits[i] = 1;

                int num = nums[i];

                List<String> traces = new ArrayList<>();
                boolean valid = dfs(nums, visits, num, 24, traces);
                if (valid) {
                    System.out.print(convertToCard(String.valueOf(num)));
                    traces.forEach(t -> System.out.print(convertToCard(t)));
                    return;
                }
                visits[i] = 0;
            }

            System.out.print("NONE");

        }
    }

    private static String convertToCard(String t) {
        // A
        if (Objects.equals(t, "1")) {
            return "A";
        } // J
        if (Objects.equals(t, "11")) {
            return "J";
        }
        // Q
        else if (Objects.equals(t, "12")) {
            return "Q";
        }
        // K
        else if (Objects.equals(t, "13")) {
            return "K";
        }
        // 数字
        else {
            return t;
        }
    }

    private static boolean dfs(int[] nums, int[] visits, int expect, int current, List<String> trace) {

        boolean visitAll = Arrays.stream(visits).allMatch(num -> num == 1);
        if (visitAll) {
            return current == expect;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visits[i] == 1) {
                continue;
            }

            visits[i] = 1;

            int num = nums[i];
            boolean addValid = dfs(nums, visits, expect, current - num, trace);
            if (addValid) {
                trace.add("+");
                trace.add(String.valueOf(num));
                return true;
            }
            boolean minusValid = dfs(nums, visits, expect, current + num, trace);
            if (minusValid) {
                trace.add("-");
                trace.add(String.valueOf(num));
                return true;
            }
            boolean multiValid = current % num == 0 && dfs(nums, visits, expect, current / num, trace);
            if (multiValid) {
                trace.add("*");
                trace.add(String.valueOf(num));
                return true;
            }
            boolean divideValid = dfs(nums, visits, expect, current * num, trace);
            if (divideValid) {
                trace.add("/");
                trace.add(String.valueOf(num));
                return true;
            }

            visits[i] = 0;
        }


        return false;

    }


    private static int[] convertToNums(String[] cards) {
        int[] ints = new int[cards.length];
        for (int i = 0; i < cards.length; i++) {
            ints[i] = convertToNum(cards[i]);
        }
        return ints;
    }

    private static int convertToNum(String card) {
        if (Objects.equals(card, "3")) {
            return 3;
        }
        if (Objects.equals(card, "4")) {
            return 4;
        }
        if (Objects.equals(card, "5")) {
            return 5;
        }
        if (Objects.equals(card, "6")) {
            return 6;
        }
        if (Objects.equals(card, "7")) {
            return 7;
        }
        if (Objects.equals(card, "8")) {
            return 8;
        }
        if (Objects.equals(card, "9")) {
            return 9;
        }
        if (Objects.equals(card, "10")) {
            return 10;
        }
        if (Objects.equals(card, "J")) {
            return 11;
        }
        if (Objects.equals(card, "Q")) {
            return 12;
        }
        if (Objects.equals(card, "K")) {
            return 13;
        }
        if (Objects.equals(card, "A")) {
            return 1;
        }
        if (Objects.equals(card, "2")) {
            return 2;
        }
        return -1;
    }
}
