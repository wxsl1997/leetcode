package org.wxsl.leetcode.hj;

import java.util.Scanner;

/**
 * @author wxsl1997
 */
public class Hj001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean hasNextLine = in.hasNextLine();
        if (hasNextLine) {
            String line = in.nextLine();
            // 最后空格位置下标
            int lastSpaceIndex = line.lastIndexOf(" ");
            System.out.println(line.substring(lastSpaceIndex + 1).length());
        }
    }
}
