package org.wxsl.leetcode.huawei23;

import java.util.Scanner;

public class Issue3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        String result = uncompress(str);
        System.out.println(result);
    }

    /**
     * 解压缩存在括号的字符串
     */
    private static String uncompress(String str) {
        int rightKuoHaoIndex = str.indexOf("}");

        // 没有括号,直接调用解密没有的方法即可
        if (rightKuoHaoIndex == -1) {
            return uncompressWithoutBracket(str);
        }

        int leftKuoHaoIndex = str.substring(0, rightKuoHaoIndex).lastIndexOf("{");

        // 右括号后面的数字
        StringBuilder numStr = new StringBuilder();
        // 右边截取的起始坐标
        int nextRightIndex = -1;
        for (int i = rightKuoHaoIndex + 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                nextRightIndex = i + 1;
                numStr.append(c);
            } else {
                nextRightIndex = i;
                break;
            }
        }

        // 括号里面的内容
        String middleStr = str.substring(leftKuoHaoIndex + 1, rightKuoHaoIndex);
        String word = uncompressWithoutBracket(middleStr);

        int repeatTime = numStr.toString().length() == 0 ? 1 : Integer.parseInt(numStr.toString());
        StringBuilder middleContent = new StringBuilder();
        for (int i = 0; i < repeatTime; i++) {
            middleContent.append(word);
        }

        StringBuilder nextWord = new StringBuilder();
        // 括号左边的内容
        String leftContent = str.substring(0, leftKuoHaoIndex);
        nextWord.append(leftContent);
        // 括号内的内弄
        nextWord.append(middleContent);

        if (nextRightIndex < str.length()) {
            // 括号左边的内容
            nextWord.append(str.substring(nextRightIndex));
        }
        // 替换掉括号继续计算
        return uncompress(nextWord.toString());
    }

    /**
     * 解压缩没有括号的字符串
     */
    private static String uncompressWithoutBracket(String word) {

        StringBuilder result = new StringBuilder();


        StringBuilder numStr = new StringBuilder();
        StringBuilder cases = new StringBuilder();


        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);

            boolean digit = Character.isDigit(c);

            // 重新清空
            if (!digit && cases.toString().length() != 0) {

                int t = numStr.toString().length() == 0 ? 1 : Integer.parseInt(numStr.toString());
                for (int j = 0; j < t; j++) {
                    result.append(cases);
                }
                cases = new StringBuilder();
                numStr = new StringBuilder();
            }

            // 数字
            if (digit) {
                numStr.append(c);
            }
            // 字符
            else {
                cases.append(c);
            }
        }

        int t = numStr.toString().length() == 0 ? 1 : Integer.parseInt(numStr.toString());
        for (int j = 0; j < t; j++) {
            result.append(cases);
        }

        return result.toString();
    }
}