package com.leetcode.third;


/**
 * Z字形打印
 */
public class SolutionA {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {//根据行循环
            for (int j = 0; j + i < n; j += cycleLen) {//每一行都会打印 j(2n-2)
                ret.append(s.charAt(j + i));//首尾行只打印这个
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)//判断不是首行和尾行
                    ret.append(s.charAt(j + cycleLen - i));//中间行会打印这个(k+1)(2n-2) -i {由于循环j+ = cyclelen 所以此处j + cycleLen - i(j=cyclelen*j)}
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String result = new SolutionA().convert("LEETCODEISHIRING",5);
        System.out.printf(result);
    }
}
