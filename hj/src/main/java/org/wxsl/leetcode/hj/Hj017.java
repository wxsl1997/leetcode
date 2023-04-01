package org.wxsl.leetcode.hj;

import java.util.Scanner;

/**
 * @author wxsl1997
 */
public class Hj017 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 接收控制台参数
        String str = in.nextLine();

        String[] commands = str.split(";");

        Point point = new Point(0, 0);

        for (String command : commands) {
            executeCommand(point, command);
        }

        System.out.println(point.x + "," + point.y);
    }

    private static void executeCommand(Point point, String command) {
        boolean validCommand = command.matches("[ADWS][1-9][0-9]?");
        if (!validCommand) {
            return;
        }

        // 方向
        char direction = command.charAt(0);
        // 数量
        int num = Integer.parseInt(command.substring(1));

        // 左 x 减
        if (direction == 'A') {
            point.x -= num;
        }

        // 右 x 加
        if (direction == 'D') {
            point.x += num;

        }
        // 上 y 加
        if (direction == 'W') {
            point.y += num;

        }
        // 下 y 减
        if (direction == 'S') {
            point.y -= num;
        }
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
