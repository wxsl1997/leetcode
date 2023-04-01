package org.wxsl.leetcode.hj;

import java.util.Scanner;

/**
 *
 * @author wxsl1997
 */
public class Hj016Dp {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // 金额总数
        int money = in.nextInt();

        // 物品数
        int num = in.nextInt();


        Goods[] goods = new Goods[num];

        for (int index = 0; index < num; index++) {
            Goods good = new Goods();
            // 初始值
            goods[index] = good;
        }

        // 赋值
        for (int index = 0; index < num; index++) {
            int price = in.nextInt();
            int weight = in.nextInt();
            int parentId = in.nextInt();

            boolean isMain = parentId == 0;

            Goods good = goods[index];
            good.price = price;
            good.score = price * weight;
            good.main = isMain;

            // 附件
            if (!isMain) {
                Goods parent = goods[parentId - 1];
                // 附件1
                if (parent.child1 == null) {
                    parent.child1 = index;
                }
                // 附件2
                else {
                    parent.child2 = index;
                }
            }
        }


        // case1 主:0 附1:0 附2:0
        // case2 主:1 附1:0 附2:0
        // case3 主:1 附1:1 附2:0
        // case4 主:1 附1:0 附2:1
        // case5 主:1 附1:1 附2:1

        // 动态规划
        int[][] dp = new int[num + 1][money + 1];
        for (int goodIndex = 1; goodIndex <= num; goodIndex++) {
            for (int moneyIndex = 0; moneyIndex <= money; moneyIndex++) {

                // 初始 case 1
                int score = dp[goodIndex - 1][moneyIndex];

                Goods currentGoods = goods[goodIndex - 1];
                if (currentGoods.main) {
                    // 满足 case 2
                    if (moneyIndex >= currentGoods.price) {
                        score = Math.max(score, dp[goodIndex - 1][moneyIndex - currentGoods.price] + currentGoods.score);
                    }

                    // 满足 case 3
                    if (currentGoods.child1 != null && moneyIndex >= currentGoods.price + goods[currentGoods.child1].price) {
                        score = Math.max(score, dp[goodIndex - 1][moneyIndex - currentGoods.price - goods[currentGoods.child1].price] + currentGoods.score + goods[currentGoods.child1].score);
                    }

                    // 满足 case 4
                    if (currentGoods.child2 != null && moneyIndex >= currentGoods.price + goods[currentGoods.child2].price) {
                        score = Math.max(score, dp[goodIndex - 1][moneyIndex - currentGoods.price - goods[currentGoods.child2].price] + currentGoods.score + goods[currentGoods.child2].score);
                    }

                    // 满足 case 5
                    if (currentGoods.child1 != null && currentGoods.child2 != null && moneyIndex >= currentGoods.price + goods[currentGoods.child1].price + goods[currentGoods.child2].price) {
                        score = Math.max(score, dp[goodIndex - 1][moneyIndex - currentGoods.price - goods[currentGoods.child1].price - goods[currentGoods.child2].price] + currentGoods.score + goods[currentGoods.child1].score + goods[currentGoods.child2].score);
                    }
                }

                // 分数赋值
                dp[goodIndex][moneyIndex] = score;
            }
        }

        //输出结果
        System.out.println(dp[num][money]);
    }

    private static class Goods {

        /**
         * 价格
         */
        int price;

        /**
         * 分数
         */
        int score;

        /**
         * 是否是主件
         */
        boolean main;

        /**
         * 附件1
         */
        Integer child1;


        /**
         * 附件2
         */
        Integer child2;
    }
}
