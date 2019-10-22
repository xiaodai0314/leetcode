package com.algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 顺时针打印矩阵
 */
public class Offer29 {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        int r1 = 0;
        int r2 = matrix.length - 1;
        int c1 = 0;
        int c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            //从左往右打印一行
            for (int i = c1; i <= c2; i++) {
                ret.add(matrix[r1][i]);
            }
            //从上到下打印一列
            for (int i = r1 + 1; i <= r2; i++) {
                ret.add(matrix[i][c2]);
            }
            //从右往左打印一行
            if (r1 != r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    ret.add(matrix[r2][i]);
                }
            }
            //从下到上打印一列
            if (c1 != c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    ret.add(matrix[i][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> result = printMatrix(matrix);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
