package org.wxsl.leetcode.race.quarter.s23t;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wxsl1997
 */
public class Issue3 {

    public static void main(String[] args) {


    }

    public static int extractMantra(String[] matrix, String mantra) {


        int rowNum = getRow(matrix, mantra);

        int colNum = getCol(matrix);

        char[] cs = mantra.toCharArray();

        List<Point> previous = new LinkedList<>();
        previous.add(new Point(1, 1, 0));

        for (int i = 0; i < cs.length; i++) {

            if (previous.isEmpty()) {
                return -1;
            }

            char c = mantra.charAt(i);
            List<Point> current = new ArrayList<>();

            for (int row = 1; row < rowNum + 1; row++) {
                for (int col = 1; col < colNum + 1; col++) {
                    if (matrix[row - 1].charAt(col - 1) == c) {

                        int finalRow = row;
                        int finalCol = col;
                        int minDist = previous.stream().mapToInt(p -> Math.abs(p.x - finalRow) + Math.abs(p.y - finalCol) + p.dist).min().orElse(-1);

                        current.add(new Point(row, col, minDist + 1));
                    }
                }
            }
            previous = current;
        }

        return previous.stream().mapToInt(p -> p.dist).min().orElse(-1);
    }

    private static int getCol(String[] matrix) {
        return matrix[0].length();
    }

    private static int getRow(String[] matrix, String mantra) {

        return matrix.length;
    }

    private static class Point {
        int x;

        int y;

        int dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
