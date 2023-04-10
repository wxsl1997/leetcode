package org.wxsl.leetcode.hj;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author wxsl1997
 */
public class Hj025 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int rSize = in.nextInt();
        // 接受控制台参数 R 数组
        String[] rs = new String[rSize];
        for (int i = 0; i < rSize; i++) {
            rs[i] = in.next();
        }


        // 接受控制台参数 I 数组
        int iSize = in.nextInt();
        int[] is = new int[iSize];
        for (int i = 0; i < iSize; i++) {
            is[i] = in.nextInt();
        }

        // I 数组去重 排序
        List<String> iList = Arrays.stream(is).distinct().boxed().sorted(Comparator.naturalOrder()).map(String::valueOf).collect(Collectors.toList());

        // 满足 R<i> 包含 I
        List<List<Integer>> indexContainer = new ArrayList<>();
        for (String iStr : iList) {
            List<Integer> indexList = IntStream.range(0, rSize).filter(i -> rs[i].contains(iStr)).boxed().collect(Collectors.toList());
            indexContainer.add(indexList);
        }

        // 计数输出结果后面单词个数
        int count = 0;
        for (int i = 0; i < iList.size(); i++) {
            List<Integer> indexList = indexContainer.get(i);
            if (indexList.size() == 0) {
                continue;
            }
            count += 2;
            count += indexList.size() * 2;
        }
        System.out.print(count);

        // 输出剩余结果
        for (int i = 0; i < iList.size(); i++) {
            List<Integer> indexList = indexContainer.get(i);
            if (indexList.size() == 0) {
                continue;
            }

            System.out.print(" " + iList.get(i));
            System.out.print(" " + indexList.size());

            for (Integer index : indexList) {
                System.out.print(" " + index);
                System.out.print(" " + rs[index]);
            }
        }

    }
}