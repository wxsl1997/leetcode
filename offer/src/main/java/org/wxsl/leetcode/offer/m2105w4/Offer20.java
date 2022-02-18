package org.wxsl.leetcode.offer.m2105w4;

import java.util.HashMap;
import java.util.Map;

/**
 * 表示数值的字符串
 */
public class Offer20 {

    /**
     * 思路:状态机
     */
    public static boolean isNumber(String s) {

        int length = s.length();
        State state = State.STATE_INITIAL;

        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!STATE_TRANSFER_MAP.get(state).containsKey(type)) {
                return false;
            }
            state = STATE_TRANSFER_MAP.get(state).get(type);
        }

        return state == State.STATE_INTEGER
                || state == State.STATE_POINT
                || state == State.STATE_FRACTION
                || state == State.STATE_EXP_NUMBER
                || state == State.STATE_END;
    }

    /**
     * 思路:正则表达式
     */
    public static boolean primaryIsNumber(String s) {
        String reg = "[+-]?(\\d+[.]|[.]\\d+|\\d+[.]\\d+|\\d+)([eE][+-]?\\d+)?";
        return s.trim().matches(reg);
    }

    public static Map<State, Map<CharType, State>> STATE_TRANSFER_MAP = new HashMap<>();

    public static CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        }
        if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        }
        if (ch == '.') {
            return CharType.CHAR_POINT;
        }
        if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        }
        if (ch == ' ') {
            return CharType.CHAR_SPACE;
        }
        return CharType.CHAR_ILLEGAL;
    }

    enum State {
        // 空格
        STATE_INITIAL,
        // 符号
        STATE_INT_SIGN,
        // 整数
        STATE_INTEGER,
        // 有整数 dot
        STATE_POINT,
        // 无整数 dot
        STATE_POINT_WITHOUT_INT,
        // 小数
        STATE_FRACTION,
        // e | E
        STATE_EXP,
        // 指数符号
        STATE_EXP_SIGN,
        // 数字
        STATE_EXP_NUMBER,
        // 空格
        STATE_END;
    }

    enum CharType {
        // 数字
        CHAR_NUMBER,
        // 指数符号
        CHAR_EXP,
        // dot
        CHAR_POINT,
        // + | -
        CHAR_SIGN,
        // 空格
        CHAR_SPACE,
        // 异常符号
        CHAR_ILLEGAL
    }

    static {
        STATE_TRANSFER_MAP.put(State.STATE_INITIAL,
                new HashMap<CharType, State>() {{
                    put(CharType.CHAR_SPACE, State.STATE_INITIAL);
                    put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
                    put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
                    put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
                }}
        );
        STATE_TRANSFER_MAP.put(State.STATE_INT_SIGN,
                new HashMap<CharType, State>() {{
                    put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
                    put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
                }}
        );
        STATE_TRANSFER_MAP.put(State.STATE_INTEGER,
                new HashMap<CharType, State>() {{
                    put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
                    put(CharType.CHAR_EXP, State.STATE_EXP);
                    put(CharType.CHAR_POINT, State.STATE_POINT);
                    put(CharType.CHAR_SPACE, State.STATE_END);
                }}
        );
        STATE_TRANSFER_MAP.put(State.STATE_POINT,
                new HashMap<CharType, State>() {{
                    put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
                    put(CharType.CHAR_EXP, State.STATE_EXP);
                    put(CharType.CHAR_SPACE, State.STATE_END);
                }}
        );
        STATE_TRANSFER_MAP.put(State.STATE_POINT_WITHOUT_INT,
                new HashMap<CharType, State>() {{
                    put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
                }}
        );
        STATE_TRANSFER_MAP.put(State.STATE_FRACTION,
                new HashMap<CharType, State>() {{
                    put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
                    put(CharType.CHAR_EXP, State.STATE_EXP);
                    put(CharType.CHAR_SPACE, State.STATE_END);
                }}
        );
        STATE_TRANSFER_MAP.put(State.STATE_EXP,
                new HashMap<CharType, State>() {{
                    put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
                    put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
                }}
        );
        STATE_TRANSFER_MAP.put(State.STATE_EXP_SIGN,
                new HashMap<CharType, State>() {{
                    put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
                }}
        );
        STATE_TRANSFER_MAP.put(State.STATE_EXP_NUMBER,
                new HashMap<CharType, State>() {{
                    put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
                    put(CharType.CHAR_SPACE, State.STATE_END);
                }}
        );
        STATE_TRANSFER_MAP.put(State.STATE_END,
                new HashMap<CharType, State>() {{
                    put(CharType.CHAR_SPACE, State.STATE_END);
                }}
        );
    }

}
