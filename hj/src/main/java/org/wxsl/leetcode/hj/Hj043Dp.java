package org.wxsl.leetcode.hj;

import java.util.*;



/*
 * DFS 使用栈结构 先进后出
 * BFS 用队列形式 先进先出
 */

/**
 * @author wxsl1997
 */
public class Hj043Dp {


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

        // 深度优先遍历
        Point[][] result = bfs(maze);


        // 结果转成列表结构
        List<Point> traces = new ArrayList<>();
        Point p = result[rowNum - 1][colNum - 1];
        while (p != null) {
            traces.add(p);
            p = p.previous;
        }

        // 输出结果
        for (int i = traces.size() - 1; i >= 0; i--) {
            Point point = traces.get(i);
            System.out.printf("(%s,%s)%n", point.x, point.y);
        }
    }

    private static Point[][] bfs(int[][] maze) {

        int rowNum = maze.length;
        int colNum = maze[0].length;

        // 存放结果
        Point[][] result = new Point[rowNum][colNum];

        Queue<Point> queue = new LinkedList<>();
        // 初始队列
        queue.offer(new Point(0, 0, 0, null));


        // 访问过的路径
        int[][] used = new int[rowNum][colNum];

        int[] px = {-1, 0, 1, 0};
        int[] py = {0, -1, 0, 1};

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            // 标记已访问
            used[current.x][current.y] = 1;

            for (int i = 0; i != 4; ++i) {
                int nextX = current.x + px[i];
                int nextY = current.y + py[i];
                Point nextPoint = new Point(nextX, nextY, current.dist + 1, current);
                if (nextX >= 0 && nextX < rowNum && nextY >= 0 && nextY < colNum && used[nextX][nextY] == 0 && maze[nextX][nextY] == 0) {
                    queue.offer(nextPoint);
                    result[nextX][nextY] = nextPoint;
                }
            }
        }

        return result;
    }


    private static class Point {
        int x;
        int y;

        /**
         * 距离起点距离
         */
        int dist;

        Point previous;

        public Point(int x, int y, int dist, Point previous) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.previous = previous;
        }
    }
}
