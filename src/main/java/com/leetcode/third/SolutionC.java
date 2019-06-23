package com.leetcode.third;

import com.leetcode.proxy.Greeting;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0
 */
public class SolutionC implements Greeting {

    public int myAtoi(String str) {
        String string = str.trim();
        if(string == null || string == "" ||string.length()==0) {
            return 0;
        }

        String result = null;
        char[] chars = string.toCharArray();
        if('-' == chars[0]||'+' == chars[0]|| (chars[0]>='0'&& chars[0]<='9')) {
            result = string.substring(0,1);
            for(int i=1; i<chars.length; i++) {
                if(chars[i]>='0'&& chars[i]<='9') {
                    result = string.substring(0, i+1);
                } else {
                    break;
                }
            }
        }
        if(result == null || result.equals("+") || result.equals("-"))
            //此时strrr是String对象，如果使用==比较则比较的时内存地址
            return 0;
        //最终转换成的数字
        int num = 0;
        //使用异常机制打印结果
        try{
            num = Integer.parseInt(result);
        }catch (Exception e){
            if(result.charAt(0) == '-')
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
        return num;

    }

    public static void main(String[] args) {
        System.out.println(new SolutionC().myAtoi(" "));

    }

    public void sayHello(String name) {
        for(int i=0;i<10;i++) {
            int result = new SolutionC().myAtoi(name);
            System.out.println(i+": "+result);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
