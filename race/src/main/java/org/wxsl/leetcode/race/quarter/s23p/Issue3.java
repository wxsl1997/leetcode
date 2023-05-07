package org.wxsl.leetcode.race.quarter.s23p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Issue3 {

    public static void main(String[] args) {

        System.out.println(fieldOfGreatestBlessing(new int[][]{{565, 34, 242}, {299, 628, 870}, {724, 673, 221}, {128, 267, 917}, {561, 488, 696}, {341, 71, 604}, {835, 92, 846}, {945, 696, 973}, {554, 776, 430}, {209, 134, 594}, {987, 898, 282}, {819, 154, 462}, {618, 946, 505}, {561, 40, 677}, {602, 863, 657}, {295, 83, 718}, {456, 920, 939}, {94, 717, 813}, {611, 946, 366}, {818, 850, 85}, {395, 554, 333}, {325, 700, 628}, {590, 401, 119}, {248, 858, 499}, {298, 723, 602}, {189, 538, 646}, {194, 283, 344}, {842, 535, 866}, {192, 832, 195}}));
    }

    public static int fieldOfGreatestBlessing(int[][] forceField) {

        // 重叠的相交点
        List<Point> intersectionPoints = new ArrayList<>();
        List<Rectangle> rectangles = Arrays.stream(forceField).map(field -> new Rectangle(field[0], field[1], field[2])).collect(Collectors.toList());
        rectangles.forEach(r1 ->
                rectangles.forEach(r2 -> {
                    if (r1.hasIntersection(r2)) {
                        double sx = Math.max(r1.sx, r2.sx);
                        double ex = Math.min(r1.ex, r2.ex);
                        double sy = Math.max(r1.sy, r2.sy);
                        double ey = Math.min(r1.ey, r2.ey);

                        intersectionPoints.add(new Point(sx, sy));
                        intersectionPoints.add(new Point(sx, ey));
                        intersectionPoints.add(new Point(ex, sy));
                        intersectionPoints.add(new Point(ex, ey));
                    }
                }));

        int max = 0;
        for (Point point : intersectionPoints) {
            int current = (int) rectangles.stream().filter(r -> r.hasIntersection(point)).count();
            max = Math.max(max, current);
        }

        return max;
    }

    private static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Rectangle {

        double sx;
        double ex;
        double sy;

        double ey;

        public Rectangle(int cx, int cy, int size) {

            double radius = size / 2.0D;


            this.sx = cx - radius;
            this.sy = cy - radius;

            this.ex = cx + radius;
            this.ey = cy + radius;
        }

        public Rectangle(double sx, double ex, double sy, double ey) {
            this.sx = sx;
            this.ex = ex;
            this.sy = sy;
            this.ey = ey;
        }

        boolean hasIntersection(Point point) {
            return this.sx <= point.x && point.x <= this.ex && this.sy <= point.y && point.y <= this.ey;
        }

        boolean hasIntersection(Rectangle rectangle) {
            return this.sx <= rectangle.ex && rectangle.sx <= this.ex && this.sy <= rectangle.ey && rectangle.sy <= this.ey;
        }
    }
}