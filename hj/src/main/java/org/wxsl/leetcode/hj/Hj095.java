package org.wxsl.leetcode.hj;

import java.math.BigDecimal;
import java.util.Scanner;


/**
 * @author wxsl1997
 */
public class Hj095 {


    private static String[] dict = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 接收控制台参数
        double num = in.nextDouble();


        double left = num;


        String result = "";

        boolean hasValue = false;

        // 亿
        if (left >= 100000000) {
            int yi = (int) (left / 100000000);
            result = result + convertToRMB(yi, false) + "亿";
            left = left % 100000000;
            hasValue = true;
        }

        // 万
        if (left >= 10000) {
            int wan = (int) (left / 10000);
            result = result + convertToRMB(wan, false) + "万";
            left = left % 10000;
            hasValue = true;
        }

        // 个
        if (left >= 1) {
            result = result + convertToRMB((int) (left), hasValue);
        }

        if (num >= 1) {
            result = result + "元";
        }

        int decimalsNum = BigDecimal.valueOf(num).multiply(new BigDecimal(
                100)).intValue() % 100;
        if (decimalsNum == 0) {
            result = result + "整";
        }

        // 角
        int jiao = decimalsNum / 10;
        if (jiao >= 1) {
            result = result + dict[jiao] + "角";
        }

        // 分
        int fen = decimalsNum % 10;
        if (fen >= 1) {
            result = result + dict[fen] + "分";
        }

        System.out.print("人民币" + result);


    }

    private static String convertToRMB(int num, boolean hasValue) {

        int left = num;

        String result = "";

        int qian = left / 1000;
        if (qian >= 1) {
            left = left % 1000;
            result = result + dict[qian] + "仟";
            hasValue = true;
        }

        int bai = left / 100;
        if (bai >= 1) {
            left = left % 100;
            if (hasValue && qian == 0) {
                result += "零";
            }
            result = result + dict[bai] + "佰";
            hasValue = true;
        }

        int shi = left / 10;
        if (shi >= 1) {
            left = left % 10;
            if (hasValue && bai == 0) {
                result += "零";
            }
            if (shi > 1) {
                result = result + dict[shi] + "拾";
            } else {
                result = result + "拾";
            }
            hasValue = true;
        }

        if (left >= 1) {
            if (hasValue && shi == 0) {
                result += "零";
            }
            result = result + dict[left];
        }

        return result;
    }
}