package org.wxsl.leetcode.race.quarter.s23;

import java.util.Arrays;

public class Issue1 {

    public static void main(String[] args) {
        supplyWagon(new int[]{7, 3, 6, 1, 8});
    }

    public static int[] supplyWagon(int[] supplies) {

        int len = supplies.length;


        int expectLen = len / 2;


        dfs(supplies, expectLen);


        return Arrays.stream(supplies).filter(n -> n != 0).toArray();
    }

    private static void dfs(int[] supplies, int expectLen) {

        long supplySize = Arrays.stream(supplies).filter(n -> n != 0).count();
        if (supplySize == expectLen) {
            return;
        }


        int minValue = Integer.MAX_VALUE;

        int minIndex = 0;
        int minNeighborIndex = -1;


        for (int index = 0; index < supplies.length - 1; index++) {
            if (supplies[index] == 0) {
                continue;
            }

            int neighborIndex = -1;
            for (int neighbor = index + 1; neighbor < supplies.length; neighbor++) {

                if (supplies[neighbor] == 0) {
                    continue;
                }
                neighborIndex = neighbor;
                break;
            }

            if (neighborIndex == -1) {
                continue;
            }

            if (supplies[index] + supplies[neighborIndex] < minValue) {
                minIndex = index;
                minNeighborIndex = neighborIndex;
                minValue = supplies[minIndex] + supplies[neighborIndex];
            }
        }

        if (minNeighborIndex != -1) {
            supplies[minIndex] = minValue;
            supplies[minNeighborIndex] = 0;
        }


        dfs(supplies, expectLen);
    }

}