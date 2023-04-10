package org.wxsl.leetcode.hj;

import java.util.*;

/**
 * @author wxsl1997
 */
public class Hj098 {

    static int BALANCE = 0;
    private static int[] PRICES = new int[]{2, 3, 4, 5, 8, 6};
    private static int[] MONEYS = new int[]{1, 2, 5, 10};
    private static final List<MoneyBox> MONEY_BOX = new ArrayList<>();
    private static final List<Item> ITEMS = new ArrayList<>();

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        String line = in.nextLine();

        String[] commands = line.split(";");


        for (String command : commands) {
            char commandType = command.charAt(0);
            if (commandType == 'r') {
                handInitCommand(command);
            }


            if (commandType == 'p') {
                handleTouBiCommand(command);
            }

            if (commandType == 'b') {
                handleBuyCommand(command);
            }

            if (commandType == 'c') {
                handleTuiBiCommand(command);
            }

            if (commandType == 'q') {
                handQueryCommand(command);
            }
        }
    }

    private static void handleTuiBiCommand(String ignore) {
        if (BALANCE == 0) {
            System.out.println("E009:Work failure");
            return;
        }


        List<MoneyBox> outMoneys = new ArrayList<>();

        for (int i = MONEY_BOX.size() - 1; i >= 0; i--) {

            MoneyBox moneyBox = MONEY_BOX.get(i);

            int num = Math.min(BALANCE / moneyBox.money, moneyBox.num);
            outMoneys.add(new MoneyBox(moneyBox.money, num));

            moneyBox.num -= num;
            BALANCE -= moneyBox.money * num;
        }

        outMoneys.stream()
                .sorted(Comparator.comparing(s -> s.money))
                .forEach(m -> System.out.printf("%s yuan coin number=%s%n", m.money, m.num));

    }

    private static void handleBuyCommand(String command) {
        String itemName = command.split(" ")[1];

        Optional<Item> itemOptional = ITEMS.stream().filter(item -> Objects.equals(item.name, itemName)).findFirst();
        if (!itemOptional.isPresent()) {
            System.out.println("E006:Goods does not exist");
            return;
        }

        Item item = itemOptional.get();
        if (item.num == 0) {
            System.out.println("E007:The goods sold out");
            return;
        }

        if (BALANCE < item.price) {
            System.out.println("E008:Lack of balance");
            return;
        }

        BALANCE -= item.price;
        item.num--;

        System.out.printf("S003:Buy success,balance=%s%n", BALANCE);

    }

    private static void handleTouBiCommand(String command) {
        int moneyNum = Integer.parseInt(command.split(" ")[1]);

        boolean notSupportType = Arrays.stream(MONEYS).noneMatch(m -> m == moneyNum);
        if (notSupportType) {
            System.out.println("E002:Denomination error");
            return;
        }

        if (moneyNum > 2) {
            int sum = MONEY_BOX.stream().filter(m -> m.money <= 2).mapToInt(m -> m.money * m.num).sum();
            if (sum < moneyNum) {
                System.out.println("E003:Change is not enough, pay fail");
                return;
            }
        }


        boolean itemEmpty = ITEMS.stream().allMatch(i -> i.num <= 0);
        if (itemEmpty) {
            System.out.println("E005:All the goods sold out");
            return;
        }

        for (MoneyBox moneyBox : MONEY_BOX) {
            if (moneyBox.money == moneyNum) {
                moneyBox.num++;
            }
        }

        BALANCE += moneyNum;

        System.out.printf("S002:Pay success,balance=%s%n", BALANCE);

    }

    private static void handInitCommand(String command) {

        String[] commandSlice = command.split(" ");

        String[] itemNums = commandSlice[1].split("-");
        for (int i = itemNums.length - 1; i >= 0; i--) {
            String itemNum = itemNums[i];
            String name = "A" + (i + 1);
            ITEMS.add(new Item(name, Integer.parseInt(itemNum), PRICES[i]));
        }

        String[] moneys = commandSlice[2].split("-");

        for (int i = 0; i < moneys.length; i++) {
            MONEY_BOX.add(new MoneyBox(MONEYS[i], Integer.parseInt(moneys[i])));
        }

        System.out.println("S001:Initialization is successful");
    }

    private static void handQueryCommand(String command) {
        String[] commandSlice = command.split(" ");

        if (commandSlice.length != 2) {
            System.out.println("E010:Parameter error");
            return;
        }

        String searchType = commandSlice[1];

        // 查询商品信息
        if (Objects.equals(searchType, "0")) {
            ITEMS.forEach(item -> System.out.printf("%s %s %s%n", item.name, item.price, item.num));
        }
        // 查询存钱盒信息
        else if (Objects.equals(searchType, "1")) {
            MONEY_BOX.forEach(m -> System.out.printf("%s yuan coin number=%s%n", m.money, m.num));
        }
        // 错误情景
        else {
            System.out.println("E010:Parameter error");
        }
    }

    private static class MoneyBox {

        int money;
        int num;

        public MoneyBox(int money, int num) {
            this.money = money;
            this.num = num;
        }
    }

    private static class Item {
        String name;

        int num;

        int price;

        public Item(String name, int num, int price) {
            this.name = name;
            this.num = num;
            this.price = price;
        }
    }
}