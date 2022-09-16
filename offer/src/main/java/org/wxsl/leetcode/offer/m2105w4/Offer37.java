package org.wxsl.leetcode.offer.m2105w4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Offer37 {

    public static class Codec {

        private static final String SEPARATOR = ",";
        private static final String EMPTY = "";
        private static final String NULL_STRING = "None";

        public String serialize(TreeNode root) {
            return serializeDfs(root).stream()
                    .reduce(EMPTY, (s, s2) -> s + SEPARATOR + s2, (s, s2) -> s + s2)
                    .replaceFirst(SEPARATOR, EMPTY);
        }

        private List<String> serializeDfs(TreeNode root) {
            ArrayList<String> nums = new ArrayList<>();
            if (root == null) {
                nums.add(NULL_STRING);
            } else {
                nums.add(String.valueOf(root.val));
                nums.addAll(serializeDfs(root.left));
                nums.addAll(serializeDfs(root.right));
            }
            return nums;
        }

        public TreeNode deserialize(String str) {
            List<String> data = Arrays.stream(str.split(SEPARATOR)).collect(Collectors.toList());
            return deserializeDfs(data);
        }

        private TreeNode deserializeDfs(List<String> data) {
            if (data.isEmpty()) {
                return null;
            }

            String current = data.remove(0);
            if (NULL_STRING.equals(current)) {
                return null;
            }

            TreeNode node = new TreeNode(Integer.parseInt(current));
            node.left = deserializeDfs(data);
            node.right = deserializeDfs(data);
            return node;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
