package org.wxsl.leetcode.huawei23;

import java.util.*;

public class Issue1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 缓存的代价
        int m = Integer.parseInt(in.nextLine());

        // 文件编号
        String flags = in.nextLine();
        // 文件大小
        String sizes = in.nextLine();

        String[] flagArr = flags.split(" ");
        String[] sizeArr = sizes.split(" ");
        // 转成对象
        List<FileNode> nodes = new ArrayList<>();
        for (int i = 0; i < flagArr.length; i++) {
            nodes.add(new FileNode(Integer.parseInt(flagArr[i]), Integer.parseInt(sizeArr[i])));
        }

        // 存储每个文件和出现的次数
        Map<FileNode, Integer> flagAndTimeMap = new HashMap<>(flagArr.length);
        for (FileNode node : nodes) {
            flagAndTimeMap.compute(node, (k, oldValue) -> Optional.ofNullable(oldValue).orElse(0) + 1);
        }

        int result = 0;
        for (Map.Entry<FileNode, Integer> entry : flagAndTimeMap.entrySet()) {
            FileNode node = entry.getKey();
            Integer times = entry.getValue();
            // 取缓存和每次扫描代价较小的
            result += Math.min(node.size * times, node.size + m);
        }

        System.out.println(result);
    }

    public static class FileNode {
        int flag;

        int size;

        public FileNode(int flag, int size) {
            this.flag = flag;
            this.size = size;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            FileNode fileNode = (FileNode) o;
            return flag == fileNode.flag && size == fileNode.size;
        }

        @Override
        public int hashCode() {
            return Objects.hash(flag, size);
        }
    }
}