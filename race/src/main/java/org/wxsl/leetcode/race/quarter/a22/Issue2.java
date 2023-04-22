package org.wxsl.leetcode.race.quarter.a22;


import java.util.*;

public class Issue2 {

    public int transportationHub(int[][] path) {


        Set<Integer> noCenter = new HashSet<>();

        Map<Integer, Integer> numMap = new HashMap<>();

        Set<Integer> allNode = new HashSet<>();

        for (int[] ints : path) {
            int from = ints[0];
            int to = ints[1];


            noCenter.add(from);

            allNode.add(from);
            allNode.add(to);

            if (noCenter.contains(to)) {
                continue;
            }

            numMap.compute(to, (key, oldValue) -> Optional.ofNullable(oldValue).orElse(0) + 1);
        }


        return numMap.entrySet().stream()
                .filter(e -> e.getValue() == allNode.size() - 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(-1);


    }
}
