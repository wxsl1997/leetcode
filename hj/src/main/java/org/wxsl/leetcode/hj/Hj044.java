package org.wxsl.leetcode.hj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * @author wxsl1997
 */
public class Hj044 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] sudoku = new int[9][9];

        // 接收控制台参数初始化数组
        for (int rowNun = 0; rowNun < sudoku.length; rowNun++) {
            for (int colNum = 0; colNum < sudoku[rowNun].length; colNum++) {
                sudoku[rowNun][colNum] = in.nextInt();
            }
        }

        // 填充数独
        dfs(sudoku);

        // 打印结果
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]);
                if (j < 8) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static boolean dfs(int[][] sudoku) {
        for (int rowNun = 0; rowNun < 9; rowNun++) {

            for (int colNum = 0; colNum < 9; colNum++) {


                if (sudoku[rowNun][colNum] == 0) {


                    for (int num = 1; num <= 9; num++) {

                        sudoku[rowNun][colNum] = num;

                        boolean valid = judgeValid(sudoku, rowNun, colNum);
                        if (valid) {
                            // 递归
                            boolean available = dfs(sudoku);
                            if (available) {
                                return true;
                            }
                        }

                        // 尝全部数据后任未成功代表失败
                        if (num == 9) {
                            sudoku[rowNun][colNum] = 0;
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean judgeValid(int[][] sudoku, int rowNun, int colNum) {

        // 检查行重复
        Set<Integer> container = new HashSet<>();
        for (int col = 0; col < 9; col++) {

            int num = sudoku[rowNun][col];
            if (container.contains(num)) {
                return false;
            }
            if (num > 0) {
                container.add(num);
            }
        }

        // 检查列重复
        container.clear();
        for (int row = 0; row < 9; row++) {
            int num = sudoku[row][colNum];
            if (container.contains(num)) {
                return false;
            }
            if (num > 0) {
                container.add(num);
            }
        }


        // 检查宫格重复
        int rowGrad = rowNun / 3;
        int colGrad = colNum / 3;
        container.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = sudoku[rowGrad * 3 + i][colGrad * 3 + j];
                if (container.contains(num)) {
                    return false;
                }
                if (num > 0) {
                    container.add(num);
                }
            }
        }

        return true;
    }
}