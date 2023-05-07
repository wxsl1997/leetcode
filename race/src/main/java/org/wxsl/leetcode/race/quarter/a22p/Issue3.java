package org.wxsl.leetcode.race.quarter.a22p;

import java.util.ArrayList;
import java.util.List;

public class Issue3 {


    public static final char TARGET = 'O';
    public static final char W = 'W';
    public static final char E = 'E';
    public static final char DOT = '.';

    public int[][] ballGame(int num, String[] plate) {
        List<Integer[]> container = new ArrayList<>();

        int rowNum = plate.length;
        int colNum = plate[0].length();

        char[][] chars = new char[rowNum][colNum];
        for (int i = 0; i < plate.length; i++) {
            chars[i] = plate[i].toCharArray();
        }

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {

                boolean isBorder = row == 0 || row == rowNum - 1 || col == 0 || col == colNum - 1;

                if (!isBorder) {
                    continue;
                }

                boolean isCorner = (row == 0 && col == 0) || (row == rowNum - 1 && col == 0) || (row == 0 && col == colNum - 1) || (row == rowNum - 1 && col == colNum - 1);
                if (isCorner) {
                    continue;
                }

                boolean isDot = chars[row][col] == DOT;
                if (!isDot) {
                    continue;
                }

                boolean match = match(row, col, chars, num);
                if (match) {
                    container.add(new Integer[]{row, col});
                }
            }
        }


        int[][] result = new int[container.size()][2];
        for (int i = 0; i < container.size(); i++) {
            result[i][0] = container.get(i)[0];
            result[i][1] = container.get(i)[1];
        }
        return result;
    }

    private boolean match(int row, int col, char[][] chars, int num) {

        // 上:1 右:2 下:3 左:4

        int direction = 0;
        if (row == 0) {
            direction = 3;
        }
        if (row == chars.length - 1) {
            direction = 1;
        }
        if (col == 0) {
            direction = 2;
        }
        if (col == chars[0].length - 1) {
            direction = 4;
        }


        int nextRow = row;
        int nextCol = col;
        for (int i = 0; i < num; i++) {

            if (direction == 1) {
                nextRow--;
            }

            if (direction == 2) {
                nextCol++;
            }
            if (direction == 3) {
                nextRow++;
            }

            if (direction == 4) {
                nextCol--;
            }

            if (nextCol >= chars[0].length || nextCol < 0) {
                continue;
            }

            if (nextRow >= chars.length || nextRow < 0) {
                continue;
            }

            if (chars[nextRow][nextCol] == TARGET) {
                return true;
            }

            if (chars[nextRow][nextCol] == W) {
                // 逆
                direction = (direction + 4 - 1) % 4;
            }
            if (chars[nextRow][nextCol] == E) {
                // 逆
                direction = (direction + 4 + 1) % 4;
            }
            if (direction == 0) {
                direction = 4;
            }
        }
        return false;
    }
}
