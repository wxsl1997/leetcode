package org.wxsl.leetcode.hj;

import java.util.*;

/**
 * @author wxsl1997
 */
public class Hj027 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 单词个数
        int num = in.nextInt();
        // 候选兄弟单词
        String[] ss = new String[num];
        for (int index = 0; index < num; index++) {
            ss[index] = in.next();
        }
        // 单词
        String word = in.next();

        // 结果数据位置
        int order = in.nextInt();

        // 兄弟单词
        List<String> brother = new ArrayList<>();
        for (String candidate : ss) {
            boolean isBrother = isBrother(candidate, word);
            if (isBrother) {
                brother.add(candidate);
            }
        }

        // 排序
        brother.sort(Comparator.comparing(c -> c));


        // 输出结果
        System.out.println(brother.size());

        if (brother.size() >= order) {
            System.out.println(brother.get(order - 1));
        }
    }

    private static boolean isBrother(String candidate, String word) {
        if (Objects.equals(candidate, word)) {
            return false;
        }

        if (candidate.length() != word.length()) {
            return false;
        }
        char[] candidateCs = candidate.toCharArray();
        char[] wordCs = word.toCharArray();
        Arrays.sort(candidateCs);
        Arrays.sort(wordCs);
        return new String(candidateCs).equals(new String(wordCs));
    }
}
