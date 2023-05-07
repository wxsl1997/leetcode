package org.wxsl.leetcode.race.quarter.a22t;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Issue1 {

    public static int minNumBooths(String[] demand) {

        Map<Character, Integer> result = new HashMap<>();


        for (String s : demand) {

            Map<Character, Integer> currentMap = new HashMap<>();
            char[] chars = s.toCharArray();

            for (char c : chars) {
                currentMap.compute(c, (key, oldValue) -> Optional.ofNullable(oldValue).orElse(0) + 1);
            }

            currentMap.forEach((k, v) -> {
                boolean bigger = Optional.ofNullable(result.get(k)).orElse(0) < v;
                if (bigger) {
                    result.put(k, v);
                }
            });
        }
        return result.values().stream().mapToInt(v -> v).sum();
    }

    public static void main(String[] args) {

        System.out.println(minNumBooths(new String[]{"acd", "bed", "accd"}));
    }
}
