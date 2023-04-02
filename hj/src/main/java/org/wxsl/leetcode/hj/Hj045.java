package org.wxsl.leetcode.hj;

import java.util.*;


/**
 * @author wxsl1997
 */
public class Hj045 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        for (int index = num; index > 0; index--) {

            String word = in.next();

            //  处理字符串, 转成 Map.Entry 列表
            char[] cs = word.toLowerCase().toCharArray();
            Map<Character, Integer> csMap = new HashMap<>();
            for (char c : cs) {
                csMap.compute(c, (k, oldValue) -> Optional.ofNullable(oldValue).orElse(0) + 1);
            }
            List<Map.Entry<Character, Integer>> entries = new ArrayList<>();
            csMap.entrySet().forEach(entries::add);
            entries.sort(Map.Entry.comparingByValue());

            // 计算分数
            int result = 0;
            for (int i = 0; i < entries.size(); i++) {
                result += (26 - (entries.size() - 1) + i) * entries.get(i).getValue();
            }

            // 输出结果
            System.out.println(result);
        }
    }
}
