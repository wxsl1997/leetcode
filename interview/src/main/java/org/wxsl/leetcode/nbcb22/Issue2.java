package org.wxsl.leetcode.nbcb22;

import java.util.*;

public class Issue2 {

    static Set<Client> clientSet = new HashSet<>();

    public String registered(String name, String IDCard, String password) {

        // IDCard 校验
        if (!Optional.ofNullable(IDCard).orElse("").matches("[1-9][0-9]{17}")) {
            return "身份证号不合法";
        }

        for (Client client : clientSet) {
            boolean exist = Objects.equals(client.getIDCard(), IDCard);
            if (exist) {
                return "该身份证号已被注册";
            }
        }

        // 密码校验
        boolean passwordLenValid = Optional.ofNullable(password).map(String::length).orElse(0) == 6;
        if (!passwordLenValid) {
            return "密码长度不合理";
        }

        if (!password.matches("[0-9]{6}")) {
            return "密码应由数字组成";
        }


        // 注册成功
        Client newClient = new Client(name, IDCard, password);
        clientSet.add(newClient);

        // 添加新卡
        newCard(IDCard, password);

        return "已完成注册";

    }

    public String login(String IDCard, String password) {

        Client current = null;
        for (Client client : clientSet) {
            if (Objects.equals(client.getIDCard(), IDCard)) {
                current = client;
            }
        }

        if (current == null) {
            return "请先注册";
        }

        if (!Objects.equals(password, current.getPassword())) {
            return "密码错误";
        }

        return "登录成功";


    }

    public String newCard(String IDCard, String password) {

        Client current = null;
        for (Client client : clientSet) {
            if (Objects.equals(client.getIDCard(), IDCard) && Objects.equals(password, client.getPassword())) {
                current = client;
            }
        }
        if (current == null) {
            return "无法办理新卡";
        }

        int nextCardId = current.getBankcards().size() + 1;
        current.getBankcards().put(IDCard + nextCardId, 0D);


        return current.getBankcards().toString();
    }

    public static class Client {
        private String name;
        private String IDCard;
        private String password;
        private HashMap<String, Double> Bankcards;

        public Client(String name, String IDCard, String password) {
            this.name = name;
            this.IDCard = IDCard;
            this.password = password;
            this.Bankcards = new HashMap<>();
        }

        public String getName() {
            return name;
        }

        public String getIDCard() {
            return IDCard;
        }

        public String getPassword() {
            return password;
        }

        public HashMap<String, Double> getBankcards() {
            return Bankcards;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Client client = (Client) o;
            return Objects.equals(name, client.name) && Objects.equals(IDCard, client.IDCard) && Objects.equals(password, client.password) && Objects.equals(Bankcards, client.Bankcards);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, IDCard, password, Bankcards);
        }
    }
}


