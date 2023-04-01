package org.wxsl.leetcode.hj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author wxsl1997
 */
public class Hj026 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 接受控制台参数
        String str = in.nextLine();

        // 英文字符
        String caseStr = str.replaceAll("[^A-Za-z]", "");

        List<Character> cases = new ArrayList<>(caseStr.length());
        for (char c : caseStr.toCharArray()) {
            cases.add(c);
        }
        // 排序
        cases.sort(Comparator.comparing(c -> c.toString().toLowerCase()));


        StringBuilder result = new StringBuilder();
        int caseIndex = 0;
        for (char c : str.toCharArray()) {
            // 英文字符
            boolean isCase = c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
            if (isCase) {
                result.append(cases.get(caseIndex++));
            }
            // 特殊字符
            else {
                result.append(c);
            }
        }

        System.out.println(result);
    }
}
