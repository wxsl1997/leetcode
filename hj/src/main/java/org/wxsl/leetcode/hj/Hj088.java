package org.wxsl.leetcode.hj;

import java.util.Scanner;


/**
 * @author wxsl1997
 */
public class Hj088 {


    public static final String JOKER = "joker";

    public static String ALL_CARD = "3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] typeScore = new int[]{1, 1, 1, 2, 1, 3};

        // 接收控制台参数
        String line = in.nextLine();

        String[] cards = line.split("-");

        // 左边牌
        String[] leftCards = cards[0].split(" ");
        // 右边牌
        String[] rightCards = cards[1].split(" ");


        int leftType = judgeType(leftCards);
        int rightType = judgeType(rightCards);

        // 类型不同, 存在炸弹
        if (typeScore[leftType] != typeScore[rightType]) {
            String winner = typeScore[leftType] > typeScore[rightType] ? cards[0] : cards[1];
            System.out.println(winner);
        }
        // 同类型牌比较
        else if (leftType == rightType) {

            // 只需比较一张牌即可
            int leftCardScore = getCardScore(leftCards[0]);
            int rightCardScore = getCardScore(rightCards[0]);
            String winner = leftCardScore > rightCardScore ? cards[0] : cards[1];
            System.out.println(winner);
        }
        // 错误比较
        else {
            System.out.println("ERROR");
        }
    }

    private static int getCardScore(String card) {

        return ALL_CARD.indexOf(card);
    }

    private static int judgeType(String[] cards) {

        // 王炸
        if (cards.length == 2 && cards[0].equalsIgnoreCase(JOKER) && cards[1].equalsIgnoreCase(JOKER)) {
            return 5;
        }
        // 单牌
        if (cards.length == 1) {
            return 0;
        }
        // 对子
        if (cards.length == 2) {
            return 1;
        }
        // 三个
        if (cards.length == 3) {
            return 2;
        }
        // 炸弹
        if (cards.length == 4) {
            return 3;
        }
        // 顺子
        if (cards.length == 5) {
            return 4;
        }
        return -1;
    }
}
