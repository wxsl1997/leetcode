package org.wxsl.leetcode.offer.m2105w3;


import java.util.*;
import java.util.stream.Stream;

/**
 * 字符串的排列
 */
public class Offer38 {

    private static final String EMPTY = "";

    /**
     * 思路:回溯算法
     */
    public static String[] permutation(String s) {

        List<String> results = new LinkedList<>();

        char[] chars = s.toCharArray();

        dfs(chars, results, new StringBuilder(), new boolean[chars.length]);

        return results.toArray(new String[0]);
    }

    private static void dfs(char[] chars, List<String> results, StringBuilder builder, boolean[] visited) {


        if (builder.length() == chars.length) {
            // 探索终点
            results.add(builder.toString());
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int cur = 0; cur < chars.length; cur++) {

            // 减枝
            if (visited[cur] || set.contains(chars[cur])) {
                continue;
            }
            set.add(chars[cur]);

            //追加字符
            builder.append(chars[cur]);
            //标记访问
            visited[cur] = true;

            //探索
            dfs(chars, results, builder, visited);

            //移除访问
            visited[cur] = false;
            //删减字符
            builder.delete(builder.length() - 1, builder.length());
        }
    }

    /**
     * 初始思路:递归实现
     */
    public static String[] primaryPermutation(String s) {

        if (s.length() == 1) {
            return new String[]{s};
        }

        return Arrays.stream(s.split(EMPTY))
                .map(e1 -> Arrays.stream(primaryPermutation(s.replaceFirst(e1, EMPTY))).map(e2 -> e1 + e2))
                .flatMap(Stream::distinct)
                .distinct()
                .toArray(String[]::new);
    }
}