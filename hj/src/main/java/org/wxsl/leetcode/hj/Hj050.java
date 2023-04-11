package org.wxsl.leetcode.hj;

import java.util.*;

/**
 * @author wxsl1997
 */
public class Hj050 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String expression = in.nextLine();

        List<Node> nodes = convertToExpressionNode(expression);

        Stack<Node> numStack = new Stack<>();
        Stack<Node> operatorStack = new Stack<>();

        nodes.forEach(node -> {
            // 数字 直接进栈
            if (node.type == 1) {
                numStack.push(node);
                return;
            }

            // 空栈 或者 栈顶是左括号 或者 高优先级操作符, 进栈
            boolean needInStack = operatorStack.isEmpty() || operatorStack.peek().leftBracket() || node.calcPriority() > operatorStack.peek().calcPriority();
            if (needInStack) {
                operatorStack.push(node);
                return;
            }

            // 右括号, 出栈, 直到遇见 左括号
            if (node.rightBracket()) {
                Node operator = operatorStack.pop();
                while (!operator.leftBracket()) {

                    Node right = numStack.pop();
                    Node left = numStack.pop();
                    Integer num = calcExpression(left.value, operator.value, right.value);
                    numStack.push(new Node(1, String.valueOf(num)));

                    operator = operatorStack.pop();
                }
                return;
            }

            // 运算, 直到遇见 左括号 或者 高优先级
            while (!operatorStack.isEmpty() && node.calcPriority() <= operatorStack.peek().calcPriority()) {
                if (operatorStack.peek().leftBracket()) {
                    break;
                }
                Node right = numStack.pop();
                Node left = numStack.pop();
                Node operator = operatorStack.pop();
                Integer num = calcExpression(left.value, operator.value, right.value);
                // 数值栈
                numStack.push(new Node(1, String.valueOf(num)));

            }
            // 操作符 进栈
            operatorStack.push(node);
        });

        // 剩余操作符出栈
        while (!operatorStack.isEmpty()) {
            Node right = numStack.pop();
            Node left = numStack.pop();
            Node operator = operatorStack.pop();
            Integer num = calcExpression(left.value, operator.value, right.value);
            numStack.push(new Node(1, String.valueOf(num)));
        }

        System.out.println(numStack.peek().value);
    }

    private static Integer calcExpression(String leftValue, String operator, String rightValue) {

        switch (operator) {
            case "+": {
                return Integer.parseInt(leftValue) + Integer.parseInt(rightValue);
            }
            case "-": {
                return Integer.parseInt(leftValue) - Integer.parseInt(rightValue);

            }
            case "*": {
                return Integer.parseInt(leftValue) * Integer.parseInt(rightValue);

            }
            case "/": {
                return Integer.parseInt(leftValue) / Integer.parseInt(rightValue);
            }
            default: {
                throw new UnsupportedOperationException(String.format("occur unsupported operator:%s", operator));
            }
        }
    }

    private static List<Node> convertToExpressionNode(String expression) {
        List<Node> nodes = new ArrayList<>();

        for (int current = 0; current < expression.length(); current++) {
            char c = expression.charAt(current);

            boolean isNumber = Character.isDigit(c);
            if (isNumber) {
                boolean continuousNum = !nodes.isEmpty() && nodes.get(nodes.size() - 1).type == 1;
                // 连续数字情形
                if (continuousNum) {
                    nodes.get(nodes.size() - 1).value += c;
                }
                // 新 node
                else {
                    nodes.add(new Node(1, String.valueOf(c)));
                }
                continue;
            }

            // 负数开始
            boolean negativeNum = c == '-' && (current == 0 || expression.charAt(current - 1) == '(' || expression.charAt(current - 1) == '[' || expression.charAt(current - 1) == '{');
            if (negativeNum) {
                nodes.add(new Node(1, String.valueOf(c)));
            }
            // 运算符
            else {
                nodes.add(new Node(2, String.valueOf(c)));
            }
        }
        return nodes;
    }

    private static class Node {

        /**
         * 1-数字;2-运算符
         */
        int type;

        String value;

        public boolean leftBracket() {
            return calcPriority() == Integer.MAX_VALUE;
        }

        public boolean rightBracket() {
            return calcPriority() == Integer.MIN_VALUE;
        }

        public int calcPriority() {

            // 加减
            if (Objects.equals(value, "+")) {
                return 1;
            }
            if (Objects.equals(value, "-")) {
                return 1;
            }

            // 乘除
            if (Objects.equals(value, "*")) {
                return 2;
            }
            if (Objects.equals(value, "/")) {
                return 3;
            }

            // 左括号
            if (Objects.equals(value, "(")) {
                return Integer.MAX_VALUE;
            }
            if (Objects.equals(value, "[")) {
                return Integer.MAX_VALUE;
            }
            if (Objects.equals(value, "{")) {
                return Integer.MAX_VALUE;
            }

            // 右括号
            if (Objects.equals(value, ")")) {
                return Integer.MIN_VALUE;
            }
            if (Objects.equals(value, "]")) {
                return Integer.MIN_VALUE;
            }
            if (Objects.equals(value, "}")) {
                return Integer.MIN_VALUE;
            }
            throw new RuntimeException(String.format("assert exception, type:%s, value:%s", type, value));
        }

        public Node(int type, String value) {
            this.type = type;
            this.value = value;
        }
    }
}
