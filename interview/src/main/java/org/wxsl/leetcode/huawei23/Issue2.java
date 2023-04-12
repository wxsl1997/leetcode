package org.wxsl.leetcode.huawei23;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class Issue2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str1 = in.next();
        String str2 = in.next();

        long maxSize = distinctCaseNum(str2);

        String[] split = str1.split("[a-f0-9]+");
        Optional<String> first = Arrays.stream(split).filter(s -> !Objects.equals("", s))
                .distinct()
                .filter(s -> distinctCaseNum(s) <= maxSize)
                // 倒序取 first
                .min((o1, o2) -> {
                    long o2Size = distinctCaseNum(o2);
                    long o1Size = distinctCaseNum(o1);

                    int c = (int) (o2Size - o1Size);
                    if (c != 0) {
                        return c;
                    }
                    return o2.compareTo(o1);
                });
        if (first.isPresent()) {
            System.out.println(first.get());
        } else {
            System.out.println("Not Found");
        }
    }

    private static long distinctCaseNum(String str2) {
        return Arrays.stream(str2.split("")).distinct().count();
    }
}