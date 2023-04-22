package org.wxsl.leetcode.race.quarter.s23;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Issue2 {

    public static int adventureCamp(String[] expeditions) {


        Set<String> knownCampsites = Arrays.stream(expeditions[0].split("->")).collect(Collectors.toSet());

        int minIndex = -1;
        int newCampsiteNum = 0;


        for (int index = 1; index < expeditions.length; index++) {

            List<String> exploreCampsites = Arrays.asList(expeditions[index].split("->"));

            List<String> newCampsites = exploreCampsites.stream().filter(c -> !Objects.equals(c, "")).filter(c -> !knownCampsites.contains(c)).distinct().collect(Collectors.toList());

            knownCampsites.addAll(newCampsites);

            if (newCampsites.size() > newCampsiteNum) {
                minIndex = index;
                newCampsiteNum = newCampsites.size();
            }
        }


        return minIndex;
    }
}