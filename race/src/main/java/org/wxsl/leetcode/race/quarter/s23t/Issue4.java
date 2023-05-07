package org.wxsl.leetcode.race.quarter.s23t;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author wxsl1997
 */
public class Issue4 {

    public static void main(String[] args) {
        System.out.println(evolutionaryRecord(new int[]{-1, 0, 0, 2}));
    }

    public static String evolutionaryRecord(int[] parents) {

        Map<Integer, List<Integer>> childMap = IntStream.range(1, parents.length).boxed()
                .collect(Collectors.groupingBy(index -> parents[index], Collectors.toList()));

        String dfs = dfs(childMap, 0);

        // 去掉 后缀 1
        int lastZeroIndex = dfs.lastIndexOf("0");
        return dfs.substring(0, lastZeroIndex + 1);
    }

    private static String dfs(Map<Integer, List<Integer>> childMap, int parentIndex) {


        StringBuilder result = new StringBuilder();

        childMap.getOrDefault(parentIndex, new ArrayList<>()).stream()
                .map(c -> "0" + dfs(childMap, c) + "1")
                .sorted(String::compareTo)
                .forEach(result::append);

        return result.toString();
    }
}
