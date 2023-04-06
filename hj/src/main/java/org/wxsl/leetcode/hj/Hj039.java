package org.wxsl.leetcode.hj;

import java.util.Scanner;


/**
 * @author wxsl1997
 */
public class Hj039 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {

            String mask = in.nextLine();
            String ip1 = in.nextLine();
            String ip2 = in.nextLine();

            boolean maskValid = maskValid(mask);
            boolean ip1Valid = ipValid(ip1);
            boolean ip2Valid = ipValid(ip2);

            // 格式有误
            if (!maskValid || !ip1Valid || !ip2Valid) {
                System.out.println(1);
            }
            // 格式正确
            else {
                // 转成10进制
                long maskDex = toDex(mask);
                long ip1Dex = toDex(ip1);
                long ip2Dex = toDex(ip2);
                // 输出接口
                int result = (maskDex & ip1Dex) == (maskDex & ip2Dex) ? 0 : 2;
                System.out.println(result);
            }
        }
    }

    private static long toDex(String ip) {
        String binary = toBinaryString(ip);
        return Long.parseLong(binary, 2);
    }

    private static String toBinaryString(String ip) {


        String[] ipFragment = ip.split("[.]");
        StringBuilder sb = new StringBuilder();

        for (String fragment : ipFragment) {
            String binaryFragment = "00000000" + Integer.toBinaryString(Integer.parseInt(fragment));
            sb.append(binaryFragment.substring(binaryFragment.length() - 8));
        }
        return sb.toString();
    }

    private static boolean maskValid(String mask) {
        if (!ipValid(mask)) {
            return false;
        }
        String maskBinary = toBinaryString(mask);
        return maskBinary.matches("1+0+");
    }

    private static boolean ipValid(String ip) {

        String[] split = ip.split("[.]");
        if (split.length != 4) {
            return false;
        }

        for (String ipFragment : split) {
            boolean fragmentValid = ipFragment.matches("\\d+") && Integer.parseInt(ipFragment) <= 255;
            if (!fragmentValid) {
                return false;
            }
        }
        return true;
    }
}
