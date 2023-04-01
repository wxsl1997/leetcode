package org.wxsl.leetcode.hj;

import java.util.Scanner;

/**
 * @author wxsl1997
 */
public class Hj033 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 接收控制台参数IP地址
        String ipAddr = in.nextLine();

        // 接收控制台参数十进制IP地址
        String ipDigit = in.nextLine();

        // 输出结果
        System.out.println(toDex(ipAddr));
        System.out.println(toIp(ipDigit));
    }

    private static String toIp(String ipDigit) {

        long nun = Long.parseLong(ipDigit);

        long fragment4 = nun % (1 << 8);
        long fragment3 = (nun >> 8) % (1 << 8);
        long fragment2 = (nun >> 16) % (1 << 8);
        long fragment1 = (nun >> 24) % (1 << 8);

        return String.format("%s.%s.%s.%s", fragment1, fragment2, fragment3, fragment4);
    }

    private static Long toDex(String ipAddr) {

        String[] ipFragments = ipAddr.split("[.]");
        return (Long.parseLong(ipFragments[0]) << 24)
                + (Long.parseLong(ipFragments[1]) << 16)
                + (Long.parseLong(ipFragments[2]) << 8)
                + Long.parseLong(ipFragments[3]);

    }

}
