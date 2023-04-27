package org.wxsl.leetcode.hj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wxsl1997
 */
public class Hj092 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {

            String str = in.nextLine();

            String[] digits = str.split("[^0-9]+");

            int max = Arrays.stream(digits).mapToInt(String::length).max().orElse(0);

            Arrays.stream(digits).filter(s -> s.length() == max).forEach(System.out::print);

            System.out.printf(",%s%n", max);
        }
    }
}
