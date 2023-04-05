package org.wxsl.leetcode.hj;

import java.util.Scanner;


/**
 * @author wxsl1997
 */
public class Hj018 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int typeA = 0;
        int typeB = 0;
        int typeC = 0;
        int typeD = 0;
        int typeE = 0;
        int typeError = 0;
        int typePrivate = 0;

        while (in.hasNextLine()) {
            String ipAddr = in.nextLine();

            String[] split = ipAddr.split("~");
            String ip = split[0];
            int ipFragment1 = getIpFragment(ip, 0);
            if (ipFragment1 == 0 || ipFragment1 == 127) {
                continue;
            }

            boolean valid = isValid(ipAddr);
            // 正常IP
            if (valid) {

                int ipFragment2 = getIpFragment(ip, 1);
                // 私有IP
                boolean isPrivateType = ipFragment1 == 10 || (ipFragment1 == 172 && ipFragment2 >= 16 && ipFragment2 <= 31) || (ipFragment1 == 192 && ipFragment2 == 168);
                if (isPrivateType) {
                    typePrivate++;

                }
                // 类型 A
                if (ipFragment1 <= 126) {
                    typeA++;
                }
                // 类型 B
                else if (ipFragment1 <= 191) {
                    typeB++;
                }
                // 类型 C
                else if (ipFragment1 <= 223) {
                    typeC++;
                }
                // 类型 D
                else if (ipFragment1 <= 239) {
                    typeD++;
                }
                // 类型 E
                else {
                    typeE++;
                }
            }
            // 异常IP
            else {
                typeError++;
            }

            System.out.println(ipAddr + " valid:" + valid);
        }

        System.out.printf("%s %s %s %s %s %s %s%n", typeA, typeB, typeC, typeD, typeE, typeError, typePrivate);
    }

    private static boolean isValid(String ipAddr) {

        String[] split = ipAddr.split("~");
        if (split.length != 2) {
            return false;
        }

        String ip = split[0];
        String mask = split[1];
        return ipValid(ip) && maskValid(mask);
    }

    private static boolean maskValid(String mask) {
        if (!ipValid(mask)) {
            return false;
        }

        String[] ipFragment = mask.split("[.]");

        StringBuilder sb = new StringBuilder();

        for (String fragment : ipFragment) {
            String binaryFragment = "00000000" + Integer.toBinaryString(Integer.parseInt(fragment));
            sb.append(binaryFragment.substring(binaryFragment.length() - 8));
        }
        return sb.toString().matches("1+0+");
    }

    private static boolean ipValid(String ip) {

        String[] ipFragment = ip.split("[.]");
        if (ipFragment.length != 4) {
            return false;
        }

        for (String s : ipFragment) {

            boolean fragmentValid = s.matches("\\d+") && Integer.parseInt(s) <= 255;
            if (!fragmentValid) {
                return false;
            }
        }
        return true;
    }

    private static Integer getIpFragment(String ip, Integer fragmentIndex) {
        String[] ipFragment = ip.split("[.]");
        return Integer.valueOf(ipFragment[fragmentIndex]);
    }
}
