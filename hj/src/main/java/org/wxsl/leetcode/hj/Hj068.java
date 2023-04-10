package org.wxsl.leetcode.hj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * @author wxsl1997
 */
public class Hj068 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        // 0 desc, 1 asc
        int order = in.nextInt();

        Score[] scores = new Score[size];

        // 接收控制台参数,初始化score数组
        int id = 0;
        for (int i = 0; i < size; i++) {
            String name = in.next();
            int score = in.nextInt();
            scores[i] = new Score(++id, name, score);
        }

        // 排序后的分数
        List<Score> sortedScores = order == 1
                ? Arrays.stream(scores).sorted(Comparator.comparing(Score::getScore).thenComparing(Score::getId)).collect(Collectors.toList())
                : Arrays.stream(scores).sorted(Comparator.comparing(Score::getScore).reversed().thenComparing(Score::getId)).collect(Collectors.toList());

        // 输出结果
        sortedScores.forEach(s -> System.out.printf("%s %s%n", s.name, s.score));
    }

    private static class Score {
        int id;

        String name;

        int score;

        public Score(int id, String name, int score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }

        public int getId() {
            return id;
        }

        public int getScore() {
            return score;
        }
    }
}
