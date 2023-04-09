package org.wxsl.leetcode.hj;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author wxsl1997
 */
public class Hj019 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Map<ErrorKey, ErrorDetail> container = new HashMap<>();

        AtomicInteger index = new AtomicInteger();

        while (in.hasNextLine()) {

            String line = in.nextLine();

            String[] split = line.split(" ");
            String path = split[0];
            int lineNum = Integer.parseInt(split[1]);


            String fileName = exactFileName(path);

            container.compute(new ErrorKey(fileName, lineNum), (k, oldValue) -> {
                if (oldValue == null) {
                    oldValue = new ErrorDetail(index.incrementAndGet(), 0);
                }
                oldValue.time++;
                return oldValue;
            });
        }

        List<Map.Entry<ErrorKey, ErrorDetail>> result = container.entrySet().stream()
                .sorted(Comparator.comparing(e -> e.getValue().index, Comparator.reverseOrder()))
                .limit(8)
                .collect(Collectors.toList());

        for (int i = result.size() - 1; i >= 0; i--) {
            Map.Entry<ErrorKey, ErrorDetail> entry = result.get(i);
            System.out.printf("%s %s %s%n", entry.getKey().name, entry.getKey().lineNum, entry.getValue().time);
        }
    }

    private static String exactFileName(String path) {
        String name = path.substring(path.lastIndexOf("\\") + 1);
        return name.length() > 16 ? name.substring(name.length() - 16) : name;
    }

    private static class ErrorKey {

        String name;

        int lineNum;

        public ErrorKey(String name, int lineNum) {
            this.name = name;
            this.lineNum = lineNum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ErrorKey errorKey = (ErrorKey) o;
            return lineNum == errorKey.lineNum && Objects.equals(name, errorKey.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, lineNum);
        }
    }

    private static class ErrorDetail {

        /**
         * 序号(时间)
         */
        int index;

        /**
         * 出现次数
         */
        int time;

        public ErrorDetail(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
}