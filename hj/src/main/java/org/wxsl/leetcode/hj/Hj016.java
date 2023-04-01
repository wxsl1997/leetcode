package org.wxsl.leetcode.hj;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author wxsl1997
 */
public class Hj016 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 金额总数
        int money = in.nextInt();

        // 物品数
        int num = in.nextInt();

        List<Item> items = new ArrayList<>();
        for (int current = 0; current < num; current++) {
            int id = current + 1;
            int price = in.nextInt();
            int score = in.nextInt();
            int parentId = in.nextInt();
            Item item = new Item(id, price, score, parentId);
            items.add(item);
        }

        int score = dfs(money, items, items);
        System.out.println(score);

    }

    /**
     * 计算满意度
     *
     * @param money 剩余钱
     * @param items 商品列表
     * @return 满意度得分
     */
    private static int dfs(int money, List<Item> items, List<Item> leftItems) {

        int result = 0;

        for (Item item : leftItems) {


            // 剩余金额
            int leftMoney = money - item.getPrice();
            int score = item.getScore() * item.getPrice();

            // 购买商品
            List<Item> newLeftItems = new ArrayList<>(leftItems);
            newLeftItems.remove(item);

            // 是否需要购买主件
            boolean needBuyParent = item.getParentId() > 0 && leftItems.contains(items.get(item.getParentId() - 1));
            if (needBuyParent) {
                Item parentItem = items.get(item.getParentId() - 1);
                leftMoney = leftMoney - parentItem.getPrice();
                score = parentItem.getScore() * parentItem.getPrice();
                newLeftItems.remove(parentItem);
            }

            if (leftMoney >= 0) {
                // 计算商品最大满意度
                result = Math.max(score + dfs(leftMoney, items, newLeftItems), result);
            }
        }

        return result;
    }


    private static class Item {
        Integer id;
        Integer price;
        Integer score;
        Integer parentId;


        public Integer getPrice() {
            return price;
        }

        public Integer getScore() {
            return score;
        }

        public Integer getParentId() {
            return parentId;
        }

        public Item(Integer id, Integer price, Integer score, Integer parentId) {
            this.id = id;
            this.price = price;
            this.score = score;
            this.parentId = parentId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Item item = (Item) o;
            return Objects.equals(id, item.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
