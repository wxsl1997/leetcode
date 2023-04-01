package org.wxsl.leetcode.hj;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


/**
 * @author wxsl1997
 */
public class Hj043 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int rowNum = in.nextInt();
        int colNum = in.nextInt();

        // 迷宫数组
        int[][] maze = new int[rowNum][colNum];
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                maze[row][col] = in.nextInt();
            }
        }

        // 存储路径
        List<Point> traces = new ArrayList<>();

        Point current = new Point(0, 0);

        // 深度优先遍历
        dfs(maze, current, traces);


        // 输出结果
        traces.forEach(point -> System.out.printf("(%s,%s)%n", point.x, point.y));


    }

    private static boolean dfs(int[][] maze, Point current, List<Point> traces) {

        int rowNum = maze.length;
        int colNum = maze[0].length;

        // 越界
        if (current.x >= rowNum || current.x < 0) {
            return false;
        }
        // 越界
        if (current.y >= colNum || current.y < 0) {
            return false;
        }
        // 回路
        if (traces.contains(current)) {
            return false;
        }
        // 胡同
        if (maze[current.x][current.y] == 1) {
            return false;
        }

        traces.add(current);

        // 结束
        if (current.x == rowNum - 1 && current.y == colNum - 1) {
            return true;
        }

        // 深度遍历
        boolean valid = dfs(maze, new Point(current.x + 1, current.y), traces)
                || dfs(maze, new Point(current.x, current.y + 1), traces)
                || dfs(maze, new Point(current.x - 1, current.y), traces)
                || dfs(maze, new Point(current.x, current.y - 1), traces);
        // 减枝
        if (!valid) {
            traces.remove(current);
        }
        return valid;
    }


    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
