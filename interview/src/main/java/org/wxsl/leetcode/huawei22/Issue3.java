package org.wxsl.leetcode.huawei22;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Issue3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        List<Node> nodes = IntStream.range(0, num).mapToObj(Node::new).collect(Collectors.toList());

        while (sc.hasNext()) {
            int from = sc.nextInt();
            int to = sc.nextInt();


            nodes.get(to).addPreNode(from);
        }

        boolean matchAll = nodes.stream().allMatch(node -> {

            if (node.hasPreNode()) {
                return true;
            }

            int intLevel = 0;

            return enableReach(nodes, node, intLevel, num);
        });

        System.out.println(matchAll ? "yes" : "no");
    }

    private static boolean enableReach(List<Node> nodes, Node node, int level, int num) {

        if (!node.hasPreNode()) {
            return true;
        }

        if (level > num) {
            return false;
        }

        int nextLeve = level + 1;
        for (Integer nodeIndex : node.preNodes) {
            boolean reach = enableReach(nodes, nodes.get(nodeIndex), nextLeve, num);
            if (reach) {
                return true;
            }
        }

        return false;
    }


    public static class Node {

        int val;

        List<Integer> preNodes = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }

        public boolean hasPreNode() {
            return preNodes.size() != 0;
        }

        public void addPreNode(int nodeVal) {
            preNodes.add(nodeVal);
        }
    }
}
