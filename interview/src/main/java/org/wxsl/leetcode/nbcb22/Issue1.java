package org.wxsl.leetcode.nbcb22;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class Issue1 {


    public int FirstNotRepeatingChar(String str) {

        Map<Character, Integer> containerMap = new HashMap<>();

        char[] chars = str.toCharArray();

        for (char c : chars) {
            containerMap.compute(c, (key, oldValue) -> Optional.ofNullable(oldValue).orElse(0) + 1);
        }

        for (int i = 0; i < chars.length; i++) {

            char current = chars[i];
            if (containerMap.get(current) == 1) {
                return i;
            }
        }

        return -1;
    }
}
