package org.wxsl.leetcode.hj;

import java.util.Arrays;
import java.util.Scanner;


/**
 * @author wxsl1997
 */
public class Hj045DP {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        for (int index = num; index > 0; index--) {

            String word = in.next();

            //  处理字符串, 转成 Map.Entry 列表
            char[] cs = word.toLowerCase().toCharArray();


            // 容器存储字母出现次数
            int[] cc = new int[128];
            for (char c : cs) {
                cc[c]++;
            }
            // 排序
            Arrays.sort(cc);

            // 计算分数
            int result = 0;
            for (int i = cc.length - 1; i >= 0; i--) {
                if (cc[i] == 0) {
                    break;
                }
                result += cc[i] * (27 - cc.length + i);
            }

            // 输出结果
            System.out.println(result);

        }
    }
}
