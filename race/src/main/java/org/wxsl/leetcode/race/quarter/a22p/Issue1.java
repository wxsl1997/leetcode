package org.wxsl.leetcode.race.quarter.a22p;

public class Issue1 {

    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {


        int maxNum = 0;

        int current = 0;
        for (int i = 0; i < temperatureA.length - 1; i++) {


            boolean c1 = (temperatureA[i + 1] - temperatureA[i]) * (temperatureB[i + 1] - temperatureB[i]) > 0;
            boolean c2 = (temperatureA[i + 1] == temperatureA[i]) && (temperatureB[i + 1] == temperatureB[i]);

            boolean same = c1 || c2;
            if (same) {
                current++;
                maxNum = Math.max(current, maxNum);
            } else {
                current = 0;
            }

        }

        return maxNum;
    }

}
